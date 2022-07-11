package com.example.cruise_company.controller.dto;

import com.example.cruise_company.service.model.Port;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RouteDto {

  private Integer id;
  private Port from;
  private Port to;
}
