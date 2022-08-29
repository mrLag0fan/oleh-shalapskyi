package com.example.cruise_company.service.model;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Receipt {

  private Integer id;
  private String documentsPath;
  private BigDecimal price;
  private Integer receiptStatusId;
  private Integer linerId;
  private String userEmail;
}
