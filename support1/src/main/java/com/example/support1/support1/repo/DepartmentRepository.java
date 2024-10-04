package com.example.support1.support1.repo;

import com.example.support1.support1.dto.Department;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends ReactiveCrudRepository<Department,Integer> {

}
