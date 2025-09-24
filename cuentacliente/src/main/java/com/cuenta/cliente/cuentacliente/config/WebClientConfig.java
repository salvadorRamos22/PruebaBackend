package com.cuenta.cliente.cuentacliente.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Clase para exponer un Bean reutilizable de WebClient
 */
@Configuration
public class WebClientConfig {


    @Bean
    public WebClient.Builder webClientBuilder(){

        return WebClient.builder();
    }

}
