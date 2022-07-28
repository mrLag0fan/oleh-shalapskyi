package com.example.cruise_company.service.validation.validator;

import com.example.cruise_company.service.validation.annotation.EndDate;
import java.util.Date;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapperImpl;

public class EndDateValidator implements ConstraintValidator<EndDate, Object> {

  private String startDate;
  private String endDate;

  public void initialize(EndDate constraintAnnotation) {
    this.startDate = constraintAnnotation.startDate();
    this.endDate = constraintAnnotation.endDate();
  }

  @Override
  public boolean isValid(Object date, ConstraintValidatorContext constraintValidatorContext) {
    Object start = new BeanWrapperImpl(date).getPropertyValue(startDate);
    Object end = new BeanWrapperImpl(date).getPropertyValue(endDate);
    if (start instanceof Date && end instanceof Date) {
      return ((Date) start).before((Date) end);
    }
    return false;
  }
}
