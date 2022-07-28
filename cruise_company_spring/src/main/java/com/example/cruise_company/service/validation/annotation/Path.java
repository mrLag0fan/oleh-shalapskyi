package com.example.cruise_company.service.validation.annotation;

import com.example.cruise_company.service.validation.validator.PathValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PathValidator.class)
public @interface Path {

  String message() default "Invalid path";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
