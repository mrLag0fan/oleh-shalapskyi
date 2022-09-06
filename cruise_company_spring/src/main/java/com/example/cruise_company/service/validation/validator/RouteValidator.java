
package com.example.cruise_company.service.validation.validator;

import com.example.cruise_company.service.model.Port;
import com.example.cruise_company.service.model.Route;
import com.example.cruise_company.service.repository.RouteJpaRepository;
import com.example.cruise_company.service.validation.annotation.IsRoute;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.SneakyThrows;
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

  @SneakyThrows
  @Override
  public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
    Port startPort = getPort(object, start);
    Port endPort = getPort(object, end);
    Integer[] routesIds = getRouteId(object, routes);
    List<Route> copy = getRoutes(routesIds);
    while (copy.size() > 0) {
      int prevStart = startPort.getId();
      for (Route route : copy) {
        if (startPort.getId().equals(route.getFrom().getId())) {
          startPort = route.getTo();
          copy.remove(route);
          break;
        }
      }
      if (prevStart == startPort.getId()) {
        break;
      }
    }
    return endPort.getId().equals(startPort.getId());
  }

  private Object getFieldValue(Object object, String fieldName) throws Exception {
    Class<?> clazz = object.getClass();
    Field field = clazz.getDeclaredField(fieldName);
    field.setAccessible(true);
    return field.get(object);
  }

  private Port getPort(Object object, String fieldName) throws Exception {
    Object fieldValue = getFieldValue(object, fieldName);
    if (fieldValue instanceof Port) {
      return (Port) fieldValue;
    }
    throw new ClassCastException();
  }

  private Integer[] getRouteId(Object object, String fieldName) throws Exception {
    Object fieldValue = getFieldValue(object, fieldName);
    if (fieldValue instanceof Integer[]) {
      return (Integer[]) fieldValue;
    }
    throw new ClassCastException();
  }

  private List<Route> getRoutes(Integer[] routesIds) {
    List<Route> copyAll = routeRepository.findAll();
    List<Route> copy = new ArrayList<>();
    for (Integer i : routesIds) {
      for (Route r : copyAll) {
        if (i.equals(r.getId())) {
          copy.add(r);
        }
      }
    }
    return copy;
  }
}

