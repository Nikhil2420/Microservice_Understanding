package com.example.microservice2.microservice2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient getWebClient(){
        return WebClient.builder().baseUrl("http://localhost:8081").build();
    }
}
