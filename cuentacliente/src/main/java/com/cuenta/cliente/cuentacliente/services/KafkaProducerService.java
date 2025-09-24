package com.cuenta.cliente.cuentacliente.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Clase service que configura el envio de mensajes hacia KAFKA
 */
@Service
public class KafkaProducerService {


    @Value("${app.kafka.topic}") // se inyecta desde application.properties y evitar quemar código
    private String topic;

    //Se define template de kafka 
    private final KafkaTemplate<String, String> kafkaTemplate;

    //Se inicializa template de kafka mediante constructor
    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Método papra enviar mensaje hacia kafka
     * @param mensaje Valor a enviar a cola
     */
    public void enviarMensaje(String mensaje) {
        kafkaTemplate.send(topic, mensaje);
        System.out.println("Valor enviado: " + mensaje);
    }

}
