package com.cuenta.cliente.cuentacliente.modelos.dto;

public class TransaccionDto {

    private Long numeroCliente;
    
    private String numeroCuenta;

    private Double monto;

    private String tipoTransaccion;

    public TransaccionDto(Long numeroCliente, String numeroCuenta, Double monto, String tipoTransaccion) {
        this.numeroCliente = numeroCliente;
        this.numeroCuenta = numeroCuenta;
        this.monto = monto;
        this.tipoTransaccion = tipoTransaccion;
    }

    public Long getNumeroCliente() {
        return numeroCliente;
    }

    public void setNumeroCliente(Long numeroCliente) {
        this.numeroCliente = numeroCliente;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }
    
    

}
