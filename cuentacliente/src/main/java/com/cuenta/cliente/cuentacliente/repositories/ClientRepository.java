package com.cuenta.cliente.cuentacliente.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cuenta.cliente.cuentacliente.modelos.entities.Client;

/**
 * Interfaz repository para persistencia de datos Entidad Client
 */
@Repository
public interface ClientRepository extends CrudRepository<Client,Long> {


    /**
     * Busca un registro por numero de cliente (id)
     * @param id identificador unico del cliente
     * @return Objeto del tipo client o null si no existe
     */
    @Query("SELECT c FROM Client c WHERE c.id = ?1")
    public Client findByNumeroCliente(Long id);

}
