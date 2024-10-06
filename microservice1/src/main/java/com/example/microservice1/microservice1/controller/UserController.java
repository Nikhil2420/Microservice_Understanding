package com.example.microservice1.microservice1.controller;

import com.example.microservice1.microservice1.dto.Department;
import com.example.microservice1.microservice1.dto.Information;
import com.example.microservice1.microservice1.dto.Responce;
import com.example.microservice1.microservice1.dto.User;
import com.example.microservice1.microservice1.repo.UserRepository;
import com.example.microservice1.microservice1.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private WebClient webClient;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<String> createUser(@RequestBody User user){
        boolean isValid=this.userService.validation(user);
        return this.userService.createUser(user);
    }

    @GetMapping(value = "/allUser",produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<User> getAllUser(){
        return userRepository.findAll();
    }

    @GetMapping(value = "/fetchDepartment",produces = MediaType.APPLICATION_JSON_VALUE)
    public Responce  getAllDepartmentFromSupport1Service() {
        Flux<Department> departmentFlux= this.userService.getAllDepartmentFromSupport1Service();
        Flux<User> userFlux=this.userRepository.findAll();
        Flux<Information> informationFlux=this.userService.getAllINformationFromMicroservice2();
        Responce responce=new Responce();
        responce.setDepartment(departmentFlux);
        responce.setUser(userFlux);
        responce.setInformation(informationFlux);
        return responce;
    }

}
