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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/** 
 * Clase que realiza las transacciones de las cuentas de los clientes
*/
@Tag(name = "Transaccion API", description = "Esta API sirve para registrar transacciones de clientes CREDITO/DEBITO")
@RestController
@RequestMapping("/transaccion")
public class TransaccionRestController {


    //Inyeccion de servicios

    @Autowired
    private TransaccionService transaccionService;


    /**
     * Controller que guarda las transacciones de los clientes CREDITO/DEBITO
     * @param input Objeto que contiene los datos a guardar
     * @return ResponseEntity con mensaje plano
     * @throws BusinessRuleException 
     * @throws Exception
     */
    @Operation(description = "Registra las transacciones de los clientes", summary = "Retorna mensaje 'Transaccion recibida' si procesamiento es correcto")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Transacción recibida"),
        @ApiResponse(responseCode = "404", description = "Cliente no existe"),
        @ApiResponse(responseCode = "500", description = "Internal Server error")})
    @PostMapping
    public ResponseEntity<?> postMethodName(@RequestBody TransaccionDto input) throws BusinessRuleException,Exception {

        BalanceTransaction save = transaccionService.guardar(input);

        return new ResponseEntity<>("Transaccion recibida",HttpStatus.CREATED);
    }
    


}
