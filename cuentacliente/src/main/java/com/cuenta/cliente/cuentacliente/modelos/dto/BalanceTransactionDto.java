package com.cuenta.cliente.cuentacliente.modelos.dto;

import java.time.LocalDateTime;

public class BalanceTransactionDto {

    private Long id;

    private LocalDateTime createddate;

    private Long client_id;

    private String accoun;

    private Double amount;

    private Long balance_id;

    public BalanceTransactionDto(Long id, LocalDateTime createddate, Long client_id, String accoun, Double amount,
            Long balance_id) {
        this.id = id;
        this.createddate = createddate;
        this.client_id = client_id;
        this.accoun = accoun;
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

    public String getAccoun() {
        return accoun;
    }

    public void setAccoun(String accoun) {
        this.accoun = accoun;
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
