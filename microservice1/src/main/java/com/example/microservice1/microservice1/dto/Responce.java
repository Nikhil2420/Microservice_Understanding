package com.example.microservice1.microservice1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Responce {

    private List<User> user;
    private List<Department> department;
    private List<Information> information;

}
