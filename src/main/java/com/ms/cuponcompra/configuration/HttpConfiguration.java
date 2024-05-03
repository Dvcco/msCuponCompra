package com.ms.cuponcompra.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import static com.ms.cuponcompra.utils.Constantes.URL;

@Configuration
public class HttpConfiguration {
    @Bean
    public WebClient webClient(){
        return WebClient.builder().baseUrl(URL).build();
    }

}
