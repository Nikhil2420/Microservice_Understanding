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
@Table("information_table")
public class Information {

    private Integer infoId;
    private int exp;
    private String feedback;
}
