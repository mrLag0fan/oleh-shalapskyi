package com.example.cruise_company.exception.entity_not_found;

import com.example.cruise_company.exception.ServiceException;
import com.example.cruise_company.service.model.enums.ErrorType;

public class ReceiptNotFoundException extends ServiceException {

  private static final String DEFAULT_MASSAGE = "Receipt not found";

  public ReceiptNotFoundException() {
    super(DEFAULT_MASSAGE);
  }

  @Override
  public ErrorType getErrorType() {
    return ErrorType.VALIDATION_ERROR_TYPE;
  }
}
