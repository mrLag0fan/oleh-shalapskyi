package com.example.cruise_company_spring.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Port {

    private Integer id;
    private String name;
}
