package com.example.microservice1.microservice1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Responce {

    private Flux<Department> department;
    private Flux<Information> information;
    private Flux<User> user;
}
