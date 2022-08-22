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
public class ReceiptStatusDto {

  @JsonIgnore
  @Null(message = "ReceiptStatus id should be absent in request")
  private Integer id;

  @NotBlank(message = "ReceiptStatus name shouldn't be empty")
  private String name;
}
