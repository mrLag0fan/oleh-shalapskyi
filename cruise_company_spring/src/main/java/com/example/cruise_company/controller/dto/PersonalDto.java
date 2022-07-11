package com.example.cruise_company.controller.dto;

import com.example.cruise_company.service.model.Liner;
import com.example.cruise_company.service.model.PersonalRole;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonalDto {

  private Integer id;
  private String fullName;
  private Integer experience;
  private Liner liner;
  private PersonalRole personalRole;
}
