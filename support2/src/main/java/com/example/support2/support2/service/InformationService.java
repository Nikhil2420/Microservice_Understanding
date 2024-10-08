package com.example.support2.support2.service;

import com.example.support2.support2.dto.Information;
import com.example.support2.support2.repo.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InformationService {

    @Autowired
    private InformationRepository informationRepository;

    public Mono<Information> addInformation(Information information) {
       return informationRepository.save(information);
    }

    public Flux<Information> getAllInformation() {
        return informationRepository.findAll();
    }
}
