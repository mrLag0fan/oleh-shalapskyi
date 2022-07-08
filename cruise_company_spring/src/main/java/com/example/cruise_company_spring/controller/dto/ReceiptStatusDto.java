package com.example.cruise_company_spring.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReceiptStatusDto {

    private Integer id;
    private String name;
}
