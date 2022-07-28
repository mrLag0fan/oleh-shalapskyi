package com.example.cruise_company.service.model;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Personal {

  private Integer id;
  private String name;
  private String surname;
  private BigDecimal experience;
  private Liner liner;
  private PersonalRole personalRole;
}
