package com.example.microservice1.microservice1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table("department_table")
public class Department {

    private Integer id;
    private String departmentName;
    private String description;
}
