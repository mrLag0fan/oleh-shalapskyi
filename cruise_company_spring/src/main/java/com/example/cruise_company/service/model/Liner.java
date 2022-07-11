package com.example.cruise_company.service.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Liner {

  private Integer id;
  private Integer passengerCapacity;
  private Date startDate;
  private Date endDate;
  private BigDecimal price;
  private Integer startPortId;
  private Integer endPortId;
  private List<Route> routes;
}
