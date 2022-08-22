package com.example.cruise_company.service.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
public class Liner {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private Integer passengerCapacity;
  private Date startDate;
  private Date endDate;
  private BigDecimal price;

  @ManyToOne
  @JoinColumn(name = "start_port_id")
  private Port startPort;

  @ManyToOne
  @JoinColumn(name = "end_port_id")
  private Port endPort;

  @ManyToMany private List<Route> routes;
}
