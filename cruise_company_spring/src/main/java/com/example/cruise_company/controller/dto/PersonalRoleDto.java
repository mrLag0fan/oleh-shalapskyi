package com.example.cruise_company.controller.dto;

import com.example.cruise_company.controller.dto.group.OnCreate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonalRoleDto {

  @JsonIgnore
  @Null(message = "PersonalRole id should be absent in request")
  private Integer id;

  @NotBlank(message = "PersonalRole name shouldn't be empty", groups = OnCreate.class)
  private String name;
}
