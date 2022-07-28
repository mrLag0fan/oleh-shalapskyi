package com.example.cruise_company.controller.dto;

import com.example.cruise_company.controller.dto.group.OnCreate;
import com.example.cruise_company.controller.dto.group.OnUpdate;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonalRoleDto {

  @Min(value = 1, message = "PersonalRole id should be bigger than 0")
  @NotNull(message = "PersonalRole id shouldn't be null", groups = OnCreate.class)
  @Null(message = "PersonalRole id should be absent in request", groups = OnUpdate.class)
  private Integer id;

  @NotBlank(message = "PersonalRole name shouldn't be empty", groups = OnCreate.class)
  private String name;
}
