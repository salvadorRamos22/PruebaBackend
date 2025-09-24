package com.cuenta.cliente.cuentacliente.modelos.dto;

import java.time.LocalDateTime;


public class BalanceDto {

    private Long id;
    private LocalDateTime createddate;
    private String accoun;
    private Double balance;
    private Long client_id;
    public BalanceDto(Long id, LocalDateTime createddate, String accoun, Double balance, Long client_id) {
        this.id = id;
        this.createddate = createddate;
        this.accoun = accoun;
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
    public String getAccoun() {
        return accoun;
    }
    public void setAccoun(String accoun) {
        this.accoun = accoun;
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
