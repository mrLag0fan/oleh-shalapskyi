package com.example.cruise_company_spring.controller.dto;

import com.example.cruise_company_spring.service.model.Port;
import com.example.cruise_company_spring.service.model.Route;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LinerDto {

    private Integer id;
    private Integer passengerCapacity;
    private Date startDate;
    private Date endDate;
    private BigDecimal price;
    private Port startPort;
    private Port endPort;
    private List<Route> routes;
}
