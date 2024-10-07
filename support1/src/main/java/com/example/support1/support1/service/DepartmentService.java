package com.example.support1.support1.service;

import com.example.support1.support1.dto.Department;
import com.example.support1.support1.repo.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Mono<Department> createDepartment(Department department){
        return departmentRepository.save(department);
    }

    public Flux<Department> getAllDepartment() {
        log.info("Hey its it support1 service");
        return departmentRepository.findAll();
    }
}
