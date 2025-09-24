package com.cuenta.cliente.cuentacliente.exceptions;

import org.springframework.http.HttpStatus;

public class BusinessRuleException extends Exception{

     private Long id;

    private String code;

    private HttpStatus httpStatus;

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public BusinessRuleException(String code, HttpStatus httpStatus, String message) {
        super(message);

        this.code = code;
        this.httpStatus = httpStatus;
    }

    public BusinessRuleException(Long id, String code, HttpStatus httpStatus, String message) {
        super(message);
        this.id = id;
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public BusinessRuleException(Long id, String code, HttpStatus httpStatus, String message, Throwable cause) {
        super(message, cause);
        this.id = id;
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public BusinessRuleException(Long id, String code, HttpStatus httpStatus, Throwable cause) {
        super(cause);
        this.id = id;
        this.code = code;
        this.httpStatus = httpStatus;
    }

    public BusinessRuleException(Long id, String code, HttpStatus httpStatus, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.id = id;
        this.code = code;
        this.httpStatus = httpStatus;
    }

}
