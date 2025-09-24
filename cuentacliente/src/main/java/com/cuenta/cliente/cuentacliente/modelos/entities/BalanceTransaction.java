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
@Table(name = "balance_transactions")
public class BalanceTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CREATEDDATE")
    @CreationTimestamp
    private LocalDateTime createddate;

    @Column(name = "client")
    private Long client_id;

    @Column(name = "ACCOUNT")
    private String account;

    @Column(name = "AMOUNT")
    private Double amount;

    @Column(name = "balance_id")
    private Long balance_id;

    public BalanceTransaction() {
    }

    public BalanceTransaction(Long id, LocalDateTime createddate, Long client_id, String account, Double amount,
            Long balance_id) {
        this.id = id;
        this.createddate = createddate;
        this.client_id = client_id;
        this.account = account;
        this.amount = amount;
        this.balance_id = balance_id;
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

    public Long getClient_id() {
        return client_id;
    }

    public void setClient_id(Long client_id) {
        this.client_id = client_id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getBalance_id() {
        return balance_id;
    }

    public void setBalance_id(Long balance_id) {
        this.balance_id = balance_id;
    }


    

}
