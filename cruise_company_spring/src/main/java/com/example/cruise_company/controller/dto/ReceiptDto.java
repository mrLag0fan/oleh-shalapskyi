package com.example.cruise_company.controller.dto;

import com.example.cruise_company.controller.dto.group.OnCreate;
import com.example.cruise_company.controller.dto.group.OnUpdate;
import com.example.cruise_company.service.validation.annotation.Path;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReceiptDto {

  @Min(value = 1, message = "Receipt id should be bigger than 0")
  @NotNull(message = "Receipt id shouldn't be null", groups = OnCreate.class)
  @Null(message = "Receipt id should be absent in request", groups = OnUpdate.class)
  private Integer id;

  @Path private String documentsPath;

  @Null(message = "Price should be absent in request")
  private BigDecimal price;

  @Min(value = 1, message = "ReceiptStatus id should be bigger than 0")
  @NotNull(message = "ReceiptStatus id shouldn't be null", groups = OnCreate.class)
  private Integer receiptStatusId;

  @Min(value = 1, message = "Liner id should be bigger than 0")
  @NotNull(message = "Liner id shouldn't be null", groups = OnCreate.class)
  @Null(message = "Liner id should be absent in request", groups = OnUpdate.class)
  private Integer linerId;

  @Email
  @NotBlank(message = "User email shouldn't be empty", groups = OnCreate.class)
  @Null(message = "User email id should be absent in request", groups = OnUpdate.class)
  private String userEmail;
}
