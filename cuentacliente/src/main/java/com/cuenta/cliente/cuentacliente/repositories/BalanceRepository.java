package com.cuenta.cliente.cuentacliente.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cuenta.cliente.cuentacliente.modelos.entities.Balance;

/**
 * Interfaz repository para persistencia de datos Entidad Balance
 */
@Repository
public interface BalanceRepository extends CrudRepository<Balance,Long>{

    /**
     * Buscar un registro por numero de cuenta y numero de cliente
     * @param cuenta numero de cuenta
     * @param clientId id identificador del usuario (numero de cliente)
     * @return Objeto del tipo Balance o null si no existe
     */
    @Query("SELECT b FROM Balance b WHERE b.account = ?1 and b.client_id = ?2")
    public Balance findByCuentaYCliente(String cuenta,Long clientId);

}
