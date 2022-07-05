package com.example.cruise_company_spring.controller.dto;

import com.example.cruise_company_spring.service.model.Liner;
import com.example.cruise_company_spring.service.model.ReceiptStatus;
import com.example.cruise_company_spring.service.model.User;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ReceiptDto {

    private Integer id;
    private String documentsPath;
    private BigDecimal price;
    private ReceiptStatus receiptStatus;
    private Liner liner;
    private User user;

}
