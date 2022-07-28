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
public class UserRoleDto {

  @Min(value = 1, message = "user role id should be bigger than 0")
  @NotNull(message = "user role id shouldn't be null", groups = OnCreate.class)
  @Null(message = "user role id should be absent in request", groups = OnUpdate.class)
  private Integer id;

  @NotBlank(message = "user role name shouldn't be empty")
  private String name;
}
