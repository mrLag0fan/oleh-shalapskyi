package com.example.cruise_company.controller.dto;

import com.example.cruise_company.controller.dto.group.OnCreate;
import com.example.cruise_company.controller.dto.group.OnUpdate;
import com.example.cruise_company.service.validation.annotation.RepeatPassword;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@RepeatPassword(password = "password", repeatPassword = "repeatPassword")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

  @Email
  @Null(message = "user email should be absent in request", groups = OnUpdate.class)
  @NotBlank(message = "user email shouldn't be empty", groups = OnCreate.class)
  private String email;

  @NotBlank(message = "user password shouldn't be empty", groups = OnCreate.class)
  private String password;

  @NotBlank(message = "user repeat password shouldn't be empty", groups = OnCreate.class)
  private String repeatPassword;

  @NotNull(message = "user balance shouldn't be null", groups = OnCreate.class)
  private BigDecimal balance;

  @Min(1)
  @Null(message = "user role id should be absent in request", groups = OnUpdate.class)
  @NotNull(message = "user role id shouldn't be null", groups = OnCreate.class)
  private Integer userRoleId;
}
