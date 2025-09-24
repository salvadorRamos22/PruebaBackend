package com.cuenta.cliente.cuentacliente.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cuenta.cliente.cuentacliente.modelos.entities.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client,Long> {


    @Query("SELECT c FROM Client c WHERE c.id = ?1")
    public Client findByNumeroCliente(Long id);

}
