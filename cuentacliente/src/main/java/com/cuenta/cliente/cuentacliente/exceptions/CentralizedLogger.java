package com.cuenta.cliente.cuentacliente.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CentralizedLogger {

    public static void info(Class<?> clazz, String mensaje){

        Logger LOG = LoggerFactory.getLogger(clazz);
        LOG.info(mensaje);

    }

    public static void error(Class<?> clazz, String mensaje, Throwable throwable){

        Logger LOG = LoggerFactory.getLogger(clazz);
        LOG.error(mensaje+" | "+throwable.getMessage()+" | "+throwable.getStackTrace());

    }

     public static void warning(Class<?> clazz, String mensaje){

        Logger LOG = LoggerFactory.getLogger(clazz);
        LOG.warn(mensaje);

    }

}
