package com.example.cruise_company_spring.controller.dto;


import io.swagger.models.auth.In;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RouteDto {

    private Integer from;
    private Integer to;

}
