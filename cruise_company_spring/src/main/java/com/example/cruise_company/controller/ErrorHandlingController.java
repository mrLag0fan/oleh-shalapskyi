package com.example.cruise_company.controller;

import com.example.cruise_company.exception.ServiceException;
import com.example.cruise_company.service.model.Error;
import com.example.cruise_company.service.model.enums.ErrorType;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

@Slf4j
@RestControllerAdvice
public class ErrorHandlingController {

  @ExceptionHandler(ServiceException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public Error handleServiceException(ServiceException ex, HandlerMethod hm) {
    log.error(
        "handleServiceException: massage {}, method {} ",
        ex.getMessage(),
        hm.getMethod().getName(),
        ex);
    return new Error(ex.getMessage(), ex.getErrorType(), LocalDateTime.now());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public List<Error> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
    log.error("handlerMethodArgumentNotValidException: massage{} ", ex.getMessage(), ex);
    return ex.getBindingResult().getAllErrors().stream()
        .map(
            error ->
                new Error(
                    error.getDefaultMessage(),
                    ErrorType.VALIDATION_ERROR_TYPE,
                    LocalDateTime.now()))
        .collect(Collectors.toList());
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public Error handleException(Exception ex, HandlerMethod hm) {
    log.error(
        "handleException: massage {}, method {} ", ex.getMessage(), hm.getMethod().getName(), ex);
    return new Error(ex.getMessage(), ErrorType.FATAL_ERROR_TYPE, LocalDateTime.now());
  }
}
