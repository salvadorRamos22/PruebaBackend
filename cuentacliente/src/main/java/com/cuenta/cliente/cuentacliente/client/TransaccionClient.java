package com.cuenta.cliente.cuentacliente.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.cuenta.cliente.cuentacliente.modelos.dto.TransaccionDto;

/**
 * Clase component para definir consumo de APIs externa
 */
@Component
public class TransaccionClient {

    //Inyección de dependencias
    private final WebClient webClient;

     // se inyecta desde application.properties y evitar quemar código

     //Se inicializa webClient mediante Constructor()
    public TransaccionClient(@Value("${app.url.base}") String urlString ,WebClient.Builder webClient) {

        this.webClient = webClient.baseUrl(urlString).build();
    }



    /**
     * Método para poder guardar transacción mediante una petición POST
     * @param transaccionDto Objeto que contiene datos a guardar
     * @return Un mensaje plano
     */
    public String guardar(TransaccionDto transaccionDto){

        return webClient.post().bodyValue(transaccionDto).retrieve().bodyToMono(String.class).block();
    }

    

}
