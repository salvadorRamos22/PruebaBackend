package com.cuenta.cliente.cuentacliente.managedbean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import com.cuenta.cliente.cuentacliente.client.TransaccionClient;
import com.cuenta.cliente.cuentacliente.modelos.dto.TransaccionDto;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/** 
 * Clase Bean para administrar la pantalla transacciones.xhtml
 */
@Named("transaccionBean")
@ViewScoped
public class TransaccionBean implements Serializable {

    //Inyección de dependencias
    @Inject
    private  TransaccionClient transaccionClient;

    private TransaccionDto transaccionDto = new TransaccionDto();
    private String tipoTransaccion;

    // Lista de opciones para el select
    private final List<String> tiposTransacciones = Arrays.asList("CREDITO", "DEBITO");

    /**
     * Método que captura los valores del formulario y realiza validaciones a los datos
     * @return Mensaje plano
     */
    public String guardar() {

        if (transaccionDto.getNumeroCuenta().isBlank() || transaccionDto.getNumeroCuenta() == null) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Error", "El numero de cuenta no puede estar vacío"));

            return null;
        }

        if (transaccionDto.getMonto() == 0.0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Error", "El monto no puede ser cero"));

            return null;
        }

        if (transaccionDto.getNumeroCliente() <= 0) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Error", "El numero de cliente no puede ser menor o igual a cero"));

            return null;
        }

        if (transaccionDto.getTipoTransaccion().equals("DEBITO")) {

            transaccionDto.setMonto(transaccionDto.getMonto() * -1);
        }

        String mensaje = transaccionClient.guardar(transaccionDto);

        FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Éxito", mensaje));

        transaccionDto = new TransaccionDto();

        return "success";

    }

    public TransaccionDto getTransaccionDto() {
        return transaccionDto;
    }

    public void setTransaccionDto(TransaccionDto transaccionDto) {
        this.transaccionDto = transaccionDto;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public List<String> getTiposTransacciones() {
        return tiposTransacciones;
    }

}
