package com.example.microservice1.microservice1.service;

import com.example.microservice1.microservice1.dto.User;
import reactor.core.publisher.Mono;

public interface IUserService {

    Mono<String> createUser(User user);

    Boolean validation(User user);

    Object getAllDepartmentFromSupport1Service();
}
