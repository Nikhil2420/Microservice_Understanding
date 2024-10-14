package com.example.microservice1.microservice1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table("users_table")

public class User {
    private Integer userId;
    private String name;
    private String email;
    private String password;
    private boolean working;
}
