package com.example.cruise_company_spring.service.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Receipt {

    private Integer id;
    private String documentsPath;
    private BigDecimal price;
    private Integer receiptStatusId;
    private Integer linerId;
    private String userEmail;
}
