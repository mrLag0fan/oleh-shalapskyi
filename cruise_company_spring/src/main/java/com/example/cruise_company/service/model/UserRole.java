package com.example.cruise_company.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRole {

  private Integer id;
  private String name;
}
