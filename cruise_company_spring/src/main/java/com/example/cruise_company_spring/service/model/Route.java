package com.example.cruise_company_spring.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Route {

    private Integer id;
    private Integer from;
    private Integer to;
}
