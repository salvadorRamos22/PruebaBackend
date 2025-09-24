package com.cuenta.cliente.cuentacliente.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Clase service que configura el consumo de mensajes de KAFKA
 */
@Service
public class KafkaConsumerService {

    /**
     * Método para poder consumir los mensajes de KAFKA y pintarlos en consola
     * 
     * @param mensaje
     */
    @KafkaListener(topics = "${app.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumirMensaje(String mensaje) {
        System.out.println("Valor recibido: " + mensaje);
    }

}
