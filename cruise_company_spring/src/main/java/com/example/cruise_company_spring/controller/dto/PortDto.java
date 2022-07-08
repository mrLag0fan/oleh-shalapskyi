package com.example.cruise_company_spring.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PortDto {

    private Integer id;
    private String name;
}
