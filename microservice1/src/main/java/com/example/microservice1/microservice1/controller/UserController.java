package com.example.microservice1.microservice1.controller;


import com.example.microservice1.microservice1.dto.Department;
import com.example.microservice1.microservice1.dto.Information;
import com.example.microservice1.microservice1.dto.Responce;
import com.example.microservice1.microservice1.dto.User;
import com.example.microservice1.microservice1.repo.UserRepository;
import com.example.microservice1.microservice1.service.impl.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private WebClient webClient;

    @Autowired
    private UserRepository userRepository;


    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    public Mono<User> createUser(@RequestBody User user) {
        log.info("Aspect triggered before proceeding with the method.");
        boolean isValid = this.userService.validation(user);
        if (!isValid) return Mono.just(null);
        //hashing->cannot be decrypted
        //encryption->can be decrypted
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte hash[] = messageDigest.digest(user.getPassword().getBytes());
            StringBuilder stringBuilder = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    stringBuilder.append('0');
                }
                stringBuilder.append(hex);
            }

            user.setPassword(stringBuilder.toString());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException();
        }
        return userService.createUser(user);
    }

    @GetMapping(value = "/allUser", produces = MediaType.APPLICATION_JSON_VALUE)

    public Mono<List<User>> getAllUser(@RequestHeader Map<String, String> headers) {
        log.info("Hitted !! {}", headers);
        return userRepository.findAll().collectList();
    }

    @GetMapping(value = "/fetchDepartment", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Responce> getAllDepartmentFromSupport1Service() {
        Mono<List<User>> userFlux = userRepository.findAll().collectList();
        Mono<List<Department>> departmentFlux = userService.getAllDepartmentFromSupport1Service().collectList();
        Mono<List<Information>> informationFlux = userService.getAllINformationFromMicroservice2().collectList();
        return Mono.zip(userFlux, departmentFlux, informationFlux)
                .map(tuple -> new Responce(tuple.getT1(), tuple.getT2(), tuple.getT3()));
    }
}