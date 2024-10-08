package com.example.microservice2.microservice2.controller;

import com.example.microservice2.microservice2.dto.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/v1/proceesing")
public class ProcessingController {

    @Autowired
    private WebClient webClient;

    @GetMapping(value = "/processed",produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Information> getProcessedResult(){
        return webClient.get()
                .uri("http://localhost:9091/api/v1/information/getAllInformation")
                .accept(MediaType.APPLICATION_JSON).
                retrieve().
                bodyToFlux(Information.class);
    }


}
