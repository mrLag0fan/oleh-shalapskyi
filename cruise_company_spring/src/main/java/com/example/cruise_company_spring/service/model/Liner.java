package com.example.cruise_company_spring.service.model;

import io.swagger.models.auth.In;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
