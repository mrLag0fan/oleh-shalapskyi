package com.example.cruise_company.service.validation.validator;

import com.example.cruise_company.service.validation.annotation.Path;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PathValidator implements ConstraintValidator<Path, String> {

  private static final String REGULAR_EXPRESSION = "([a-zA-Z]:)?(\\[a-zA-Z0-9_-]+)+\\?";

  @Override
  public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
    return Pattern.compile(REGULAR_EXPRESSION).matcher(s).matches();
  }
}
