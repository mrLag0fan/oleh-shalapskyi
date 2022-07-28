package com.example.cruise_company.exception;

import com.example.cruise_company.service.model.enums.ErrorType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class ServiceException extends RuntimeException {

  private ErrorType errorType;

  public ServiceException(String massage) {
    super(massage);
  }

  public ErrorType getErrorType() {
    return ErrorType.FATAL_ERROR_TYPE;
  }
}
