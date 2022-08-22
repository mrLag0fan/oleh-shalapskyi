/*
package com.example.cruise_company.service.validation.validator;

import com.example.cruise_company.service.model.Port;
import com.example.cruise_company.service.model.Route;
import com.example.cruise_company.service.repository.RouteJpaRepository;
import com.example.cruise_company.service.validation.annotation.IsRoute;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class RouteValidator implements ConstraintValidator<IsRoute, Object> {

  private String start;
  private String end;
  private String routes;

  @Autowired private RouteJpaRepository routeRepository;

  @Override
  public void initialize(IsRoute constraintAnnotation) {
    this.start = constraintAnnotation.start();
    this.end = constraintAnnotation.end();
    this.routes = constraintAnnotation.routes();
  }

  @Override
  public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
    try {
      Object startFieldValue = getFieldValue(object, start);
      Object endFieldValue = getFieldValue(object, end);
      Object routesFieldValue = getFieldValue(object, routes);
      if (routesFieldValue instanceof Integer[]
          && startFieldValue instanceof Port
          && endFieldValue instanceof Port) {
        List<Route> copy =
            new ArrayList<>(List.of((Integer[]) routesFieldValue))
                .stream().map(x -> routeRepository.getById(x)).collect(Collectors.toList());
        while (copy.size() > 0) {
          int prevStart = ((Port) startFieldValue).getId();
          for (Route route : copy) {
            if (((Port) startFieldValue).getId().equals(route.getFrom().getId())) {
              startFieldValue = route.getTo();
              copy.remove(route);
              break;
            }
          }
          if (prevStart == ((Port) startFieldValue).getId()) {
            break;
          }
        }
        if (((Port) endFieldValue).getId().equals(((Port) startFieldValue).getId())) {
          return true;
        }
        return true;
      }
    } catch (Exception e) {
      return false;
    }
    return false;
  }

  private Object getFieldValue(Object object, String fieldName) throws Exception {
    Class<?> clazz = object.getClass();
    Field field = clazz.getDeclaredField(fieldName);
    field.setAccessible(true);
    return field.get(object);
  }
}
*/
