package com.example.cruise_company.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRoleDto {

  private Integer id;
  private String name;
}
