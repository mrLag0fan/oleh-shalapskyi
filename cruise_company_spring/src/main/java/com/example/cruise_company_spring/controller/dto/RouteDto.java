package com.example.cruise_company_spring.controller.dto;


import com.example.cruise_company_spring.service.model.Port;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RouteDto {

    private Integer id;
    private Port from;
    private Port to;
}
