package com.example.support2.support2.controller;

import com.example.support2.support2.dto.Information;
import com.example.support2.support2.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/information")
public class InformationController {

    @Autowired
    private InformationService informationService;

    @PostMapping(value = "/add",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Information> addInformation(@RequestBody Information information){
        return this.informationService.addInformation(information);
    }

    @GetMapping(value = "/getAllInformation",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Information> getAllInformation(){
        return this.informationService.getAllInformation();
    }
}
