package com.example.cruise_company.service.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Route {

  private Integer id;
  private Integer from;
  private Integer to;
}
