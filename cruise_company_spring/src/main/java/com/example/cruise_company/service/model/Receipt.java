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
  private ReceiptStatus receiptStatus;
  private Liner liner;
  private User user;
}
