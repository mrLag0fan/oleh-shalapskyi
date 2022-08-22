package com.example.cruise_company.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRoleDto {

  @JsonIgnore
  @Null(message = "user role id should be absent in request")
  private Integer id;

  @NotBlank(message = "user role name shouldn't be empty")
  private String name;
}
