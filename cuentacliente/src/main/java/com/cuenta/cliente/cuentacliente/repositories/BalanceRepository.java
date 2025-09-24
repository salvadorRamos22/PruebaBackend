package com.cuenta.cliente.cuentacliente.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cuenta.cliente.cuentacliente.modelos.entities.Balance;

@Repository
public interface BalanceRepository extends CrudRepository<Balance,Long>{

    @Query("SELECT b FROM Balance b WHERE b.account = ?1 and b.client_id = ?2")
    public Balance findByCuentaYCliente(String cuenta,Long clientId);

}
