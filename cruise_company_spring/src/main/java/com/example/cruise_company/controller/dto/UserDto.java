package com.example.cruise_company.controller.dto;

import com.example.cruise_company.service.model.UserRole;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

  private String email;
  private String password;
  private String repeatPassword;
  private BigDecimal balance;
  private UserRole userRole;
}
