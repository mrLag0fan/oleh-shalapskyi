package com.example.cruise_company.controller.dto;

import com.example.cruise_company.controller.dto.group.OnCreate;
import com.example.cruise_company.controller.dto.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RouteDto {

  @Min(value = 1, message = "route id should be bigger than 0")
  @NotNull(message = "route id shouldn't be null", groups = OnCreate.class)
  @Null(message = "route id should be absent in request", groups = OnUpdate.class)
  private Integer id;

  @Min(value = 1, message = "from port id should be bigger than 0")
  @NotNull(message = "from port id shouldn't be null", groups = OnCreate.class)
  private Integer from;

  @Min(value = 1, message = "to port id should be bigger than 0")
  @NotNull(message = "to port id shouldn't be null", groups = OnCreate.class)
  private Integer to;
}
