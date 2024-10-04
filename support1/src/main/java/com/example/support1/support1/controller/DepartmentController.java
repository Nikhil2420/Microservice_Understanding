package com.example.support1.support1.controller;

import com.example.support1.support1.dto.Department;
import com.example.support1.support1.service.DepartmentService;
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
@RequestMapping("/ap1/v1/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Department> createDepartment(@RequestBody Department department){
        return this.departmentService.createDepartment(department);
    }

    @GetMapping(value = "/getAllDepartment",produces =MediaType.APPLICATION_JSON_VALUE)
    public Flux<Department> getAllDepartment(){
        return this.departmentService.getAllDepartment();
    }
}
