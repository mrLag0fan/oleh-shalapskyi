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
public class Personal {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String name;
  private String surname;
  private BigDecimal experience;

  @ManyToOne
  @JoinColumn(name = "liner_id")
  private Liner liner;

  @ManyToOne
  @JoinColumn(name = "personal_role_id")
  private PersonalRole personalRole;
}
