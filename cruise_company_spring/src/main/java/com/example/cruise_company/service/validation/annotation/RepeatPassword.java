package com.example.cruise_company.service.validation.annotation;

import com.example.cruise_company.service.validation.validator.RepeatPasswordValidator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RepeatPasswordValidator.class)
public @interface RepeatPassword {

  String message() default "{RepeatPassword don't match password}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  String password();

  String repeatPassword();
}
