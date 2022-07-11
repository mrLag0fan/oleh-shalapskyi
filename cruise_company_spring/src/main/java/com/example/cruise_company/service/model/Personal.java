package com.example.cruise_company.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Personal {

  private Integer id;
  private String name;
  private String surname;
  private Integer experience;
  private Integer linerId;
  private Integer personalRoleId;
}
