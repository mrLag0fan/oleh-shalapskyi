package com.example.cruise_company.exception.entity_already_exists;

import com.example.cruise_company.exception.ServiceException;
import com.example.cruise_company.service.model.enums.ErrorType;

public class UserAlreadyExists extends ServiceException {

  private static final String DEFAULT_MASSAGE = "User Already Exists";

  public UserAlreadyExists() {
    super(DEFAULT_MASSAGE);
  }

  @Override
  public ErrorType getErrorType() {
    return ErrorType.VALIDATION_ERROR_TYPE;
  }
}
