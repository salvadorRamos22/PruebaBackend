package com.cuenta.cliente.cuentacliente.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cuenta.cliente.cuentacliente.modelos.entities.BalanceTransaction;

/**
 * Interfaz repository para persistencia de datos Entidad BalanceTransaccion
 */
@Repository
public interface BalanceTransaccionRepository extends CrudRepository<BalanceTransaction,Long>{

}
