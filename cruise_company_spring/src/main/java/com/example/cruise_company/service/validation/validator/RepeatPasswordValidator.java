package com.example.cruise_company.service.validation.validator;

import com.example.cruise_company.service.validation.annotation.RepeatPassword;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class RepeatPasswordValidator implements ConstraintValidator<RepeatPassword, Object> {

  private String password;
  private String repeatPassword;

  public void initialize(RepeatPassword constraintAnnotation) {
    this.password = constraintAnnotation.password();
    this.repeatPassword = constraintAnnotation.repeatPassword();
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {

    Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(password);
    Object fieldMatchValue = new BeanWrapperImpl(value).getPropertyValue(repeatPassword);

    if (fieldValue != null) {
      return fieldValue.equals(fieldMatchValue);
    } else {
      return fieldMatchValue == null;
    }
  }
}
