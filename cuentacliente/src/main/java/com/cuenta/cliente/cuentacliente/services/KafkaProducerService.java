package com.cuenta.cliente.cuentacliente.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Value("${app.kafka.topic}") // se inyecta desde application.properties y evitar quemar código
    private String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void enviarMensaje(String mensaje) {
        kafkaTemplate.send(topic, mensaje);
        System.out.println("Valor enviado: " + mensaje);
    }

}
