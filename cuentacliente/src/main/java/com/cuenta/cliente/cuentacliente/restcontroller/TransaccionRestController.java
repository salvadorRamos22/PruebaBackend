package com.cuenta.cliente.cuentacliente.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cuenta.cliente.cuentacliente.exceptions.BusinessRuleException;
import com.cuenta.cliente.cuentacliente.modelos.dto.TransaccionDto;
import com.cuenta.cliente.cuentacliente.modelos.entities.BalanceTransaction;
import com.cuenta.cliente.cuentacliente.services.TransaccionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/transaccion")
public class TransaccionRestController {


    @Autowired
    private TransaccionService transaccionService;


    @PostMapping
    public ResponseEntity<?> postMethodName(@RequestBody TransaccionDto input) throws BusinessRuleException,Exception {

        BalanceTransaction save = transaccionService.guardar(input);

        return new ResponseEntity<>("Transaccion recibida",HttpStatus.CREATED);
    }
    


}
