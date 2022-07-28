package com.example.cruise_company.controller.dto;

import com.example.cruise_company.controller.dto.group.OnCreate;
import com.example.cruise_company.controller.dto.group.OnUpdate;
import com.example.cruise_company.service.validation.annotation.EndDate;
import com.example.cruise_company.service.validation.annotation.IsRoute;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
@EndDate(endDate = "endDate", startDate = "startDate")
@IsRoute(start = "startPortId", end = "endPortId", routes = "routes")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LinerDto {

  @Min(value = 1, message = "Liner id should be bigger than 0")
  @NotNull(message = "Liner id shouldn't be null", groups = OnCreate.class)
  @Null(message = "Liner id should be absent in request", groups = OnUpdate.class)
  private Integer id;

  @Min(value = 1, message = "Liner passenger capacity should be bigger than 0")
  @NotNull(message = "Liner passenger capacity shouldn't be null", groups = OnCreate.class)
  private Integer passengerCapacity;

  @DateTimeFormat(pattern = "dd-MMM-yyyy")
  private Date startDate;

  @DateTimeFormat(pattern = "dd-MMM-yyyy")
  private Date endDate;

  @Min(value = 1, message = "Liner price should be bigger than 0")
  @NotNull(message = "Liner price shouldn't be null", groups = OnCreate.class)
  private BigDecimal price;

  @Min(value = 1, message = "Liner price should be bigger than 0")
  @NotNull(message = "Liner price shouldn't be null", groups = OnCreate.class)
  private Integer startPortId;

  @Min(value = 1, message = "Liner price should be bigger than 0")
  @NotNull(message = "Liner price shouldn't be null", groups = OnCreate.class)
  private Integer endPortId;

  private Integer[] routes;
}
