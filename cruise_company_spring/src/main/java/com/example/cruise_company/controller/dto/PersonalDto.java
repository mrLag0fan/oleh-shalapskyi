package com.example.cruise_company.controller.dto;

import com.example.cruise_company.controller.dto.group.OnCreate;
import com.example.cruise_company.controller.dto.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonalDto {

  @Min(value = 1, message = "Personal id should be bigger than 0")
  @NotNull(message = "Personal id shouldn't be null", groups = OnCreate.class)
  @Null(message = "Personal id should be absent in request", groups = OnUpdate.class)
  private Integer id;

  @Pattern(
      regexp = "([A-Z][a-z]{3,} )([A-Z][a-z]{3,} )?([A-Z][a-z]{3,})",
      message = "Personal full name invalid")
  private String fullName;

  @Min(value = 0, message = "PersonalRole id should be >= 0")
  private BigDecimal experience;

  @Min(value = 1, message = "Liner id should be bigger than 0")
  @NotNull(message = "Liner id shouldn't be null", groups = OnCreate.class)
  private Integer linerId;

  @Min(value = 1, message = "Liner id should be bigger than 0")
  @NotNull(message = "Liner id shouldn't be null", groups = OnCreate.class)
  private Integer personalRoleId;
}
