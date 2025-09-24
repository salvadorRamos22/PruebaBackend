package com.cuenta.cliente.cuentacliente.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

     @KafkaListener(topics = "${app.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumirMensaje(String mensaje) {
        System.out.println("Valor recibido: " + mensaje);
    }

}
