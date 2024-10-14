package com.example.microservice1.microservice1.service;

import com.example.microservice1.microservice1.dto.Information;
import com.example.microservice1.microservice1.dto.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IUserService {

    Mono<User> createUser(User user);

    Boolean validation(User user);

    Object getAllDepartmentFromSupport1Service();

    Flux<Information> getAllINformationFromMicroservice2();
}
