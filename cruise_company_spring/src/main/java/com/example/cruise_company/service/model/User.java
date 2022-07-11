package com.example.cruise_company.service.model;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

  private String email;
  private String password;
  private BigDecimal balance;
  private Integer userRoleId;
}
