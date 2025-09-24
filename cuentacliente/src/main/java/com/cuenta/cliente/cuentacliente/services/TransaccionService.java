package com.cuenta.cliente.cuentacliente.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.cuenta.cliente.cuentacliente.exceptions.BusinessRuleException;
import com.cuenta.cliente.cuentacliente.exceptions.CentralizedLogger;
import com.cuenta.cliente.cuentacliente.modelos.dto.TransaccionDto;
import com.cuenta.cliente.cuentacliente.modelos.entities.Balance;
import com.cuenta.cliente.cuentacliente.modelos.entities.BalanceTransaction;
import com.cuenta.cliente.cuentacliente.modelos.entities.Client;
import com.cuenta.cliente.cuentacliente.repositories.BalanceRepository;
import com.cuenta.cliente.cuentacliente.repositories.BalanceTransaccionRepository;
import com.cuenta.cliente.cuentacliente.repositories.ClientRepository;

/**
 * Clase service que contiene la lógica de negocio para regisrar una transacción
 */
@Service
public class TransaccionService {

    //Inyección de dependencias
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BalanceRepository balanceRepository;

    @Autowired
    private BalanceTransaccionRepository balanceTransaccionRepository;

    private final KafkaProducerService kafkaProducerService;

    public TransaccionService(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    /**
     * Método para guardar transacciones
     * @param transaccionDto Objeto que contiene datos de transacción
     * @return Objeto BalanceTransacction del registro recien guardado
     * @throws BusinessRuleException
     * @throws Exception
     */
    public BalanceTransaction guardar(TransaccionDto transaccionDto) throws BusinessRuleException, Exception {

        Client existCliente = clientRepository.findByNumeroCliente(transaccionDto.getNumeroCliente());
        if (existCliente == null) {

            CentralizedLogger.warning(getClass(), "Cliente no existe");

            throw new BusinessRuleException("1025", HttpStatus.NOT_FOUND, "Cliente no existe");
        }

        Balance existeBalance = balanceRepository.findByCuentaYCliente(transaccionDto.getNumeroCuenta(),
                transaccionDto.getNumeroCliente());

        BalanceTransaction save = null;

        if (existeBalance != null) {

            save = guardarBalanceTransaccion(transaccionDto, existeBalance);

            Double balanceActual = existeBalance.getBalance() + transaccionDto.getMonto();

            existeBalance.setBalance(balanceActual);
            balanceRepository.save(existeBalance);

            kafkaProducerService.enviarMensaje("Transacción recibida");

        } else {

            Balance newBalance = new Balance();
            newBalance.setAccount(transaccionDto.getNumeroCuenta());
            newBalance.setBalance(transaccionDto.getMonto());
            newBalance.setClient_id(transaccionDto.getNumeroCliente());
            Balance saveBalance = balanceRepository.save(newBalance);

            save = guardarBalanceTransaccion(transaccionDto, saveBalance);

            kafkaProducerService.enviarMensaje("Transacción recibida");

        }

        return save;

    }

    /**
     * Método para guardar BalanceTransaccion
     * @param transaccionDto Datos de transacción
     * @param balance Objeto Balance
     * @return Objeto BalanceTransaction
     */
    private BalanceTransaction guardarBalanceTransaccion(TransaccionDto transaccionDto, Balance balance) {

        BalanceTransaction newBalanceTransaccion = new BalanceTransaction();
        newBalanceTransaccion.setClient_id(balance.getClient_id());
        newBalanceTransaccion.setAccount(transaccionDto.getNumeroCuenta());
        newBalanceTransaccion.setAmount(transaccionDto.getMonto());
        newBalanceTransaccion.setBalance_id(balance.getId());

        return balanceTransaccionRepository.save(newBalanceTransaccion);

    }

}
