package com.example.cruise_company.controller.dto;

import com.example.cruise_company.service.model.Liner;
import com.example.cruise_company.service.model.ReceiptStatus;
import com.example.cruise_company.service.model.User;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReceiptDto {

  private Integer id;
  private String documentsPath;
  private BigDecimal price;
  private ReceiptStatus receiptStatus;
  private Liner liner;
  private User user;
}
