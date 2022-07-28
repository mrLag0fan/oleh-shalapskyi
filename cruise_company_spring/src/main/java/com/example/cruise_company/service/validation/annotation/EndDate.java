package com.example.cruise_company.service.validation.annotation;

import com.example.cruise_company.service.validation.validator.EndDateValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EndDateValidator.class)
public @interface EndDate {

  String message() default "{EndDate is before start date}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  String startDate();

  String endDate();
}
