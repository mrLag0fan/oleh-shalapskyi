package com.example.cruise_company.service.model;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Receipt {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String documentsPath;
  private BigDecimal price;

  @ManyToOne
  @JoinColumn(name = "receipt_status_id")
  private ReceiptStatus receiptStatus;

  @ManyToOne
  @JoinColumn(name = "liner_id")
  private Liner liner;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
}
