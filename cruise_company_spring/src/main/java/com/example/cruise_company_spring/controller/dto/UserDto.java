package com.example.cruise_company_spring.controller.dto;


import com.example.cruise_company_spring.service.model.UserRole;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class UserDto {

    private String email;
    private String password;
    private String repeatPassword;
    private BigDecimal balance;
    private UserRole userRole;

}
