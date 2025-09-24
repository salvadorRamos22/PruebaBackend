package com.cuenta.cliente.cuentacliente.modelos.entities;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "balance")
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CREATEDDATE")
    @CreationTimestamp
    private LocalDateTime createddate;

    @Column(name = "ACCOUNT")
    private String account;

    @Column(name = "BALANCE")
    private Double balance;

    @Column(name = "client_id")
    private Long client_id;

    public Balance() {
    }

    public Balance(Long id, LocalDateTime createddate, String account, Double balance, Long client_id) {
        this.id = id;
        this.createddate = createddate;
        this.account = account;
        this.balance = balance;
        this.client_id = client_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateddate() {
        return createddate;
    }

    public void setCreateddate(LocalDateTime createddate) {
        this.createddate = createddate;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    


}
