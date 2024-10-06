package com.example.microservice1.microservice1.service.impl;

import com.example.microservice1.microservice1.dto.Department;
import com.example.microservice1.microservice1.dto.Information;
import com.example.microservice1.microservice1.dto.User;
import com.example.microservice1.microservice1.repo.UserRepository;
import com.example.microservice1.microservice1.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class UserService implements IUserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebClient webClientConfig;

    @Override
    public Mono<String> createUser(User user) {
        log.info(String.valueOf(user));

        Mono<String> a =  userRepository.save(user)
                .flatMap(x-> Mono.just("success"));

        return a;
    }

    @Override
    public Boolean validation(User user) {
       boolean flag=false;
       if(user.getName().length()<2)return flag;
       if(!user.getEmail().contains("@"))return flag;
       flag=true;
       return flag;
    }

    @Override
    public Flux<Department> getAllDepartmentFromSupport1Service() {
    return webClientConfig.get().
               uri("/ap1/v1/department/getAllDepartment").
               accept(MediaType.APPLICATION_JSON).
               retrieve().
               bodyToFlux(Department.class);


    }

    @Override
    public Flux<Information> getAllINformationFromMicroservice2() {
        return webClientConfig.get()
                .uri("http:locolhost:8081/api/v1/proceesing/processed")
                .retrieve()
                .bodyToFlux(Information.class);
    }
}
