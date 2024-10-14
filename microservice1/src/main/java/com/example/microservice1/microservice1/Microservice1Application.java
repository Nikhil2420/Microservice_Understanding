package com.example.microservice1.microservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@SpringBootApplication(scanBasePackages = "com.example.microservice1")
@EnableR2dbcRepositories(basePackages = "com.example.microservice1.microservice1.repo")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Microservice1Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservice1Application.class, args);
	}

}
