package com.example.cruise_company.service.model;

import com.example.cruise_company.service.model.enums.ErrorType;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Error {

  private String massage;
  private ErrorType errorType;
  private LocalDateTime timeStamp;
}
