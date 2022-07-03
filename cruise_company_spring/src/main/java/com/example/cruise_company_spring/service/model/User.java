package com.example.cruise_company_spring.service.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class User {

    private String email;
    private String password;
    private BigDecimal balance;
    //private UserRole userRole;

}
