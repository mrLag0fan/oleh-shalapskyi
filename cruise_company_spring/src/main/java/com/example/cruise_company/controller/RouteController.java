package com.example.cruise_company.controller;

import com.example.cruise_company.api.RouteApi;
import com.example.cruise_company.controller.dto.RouteDto;
import com.example.cruise_company.controller.dto.group.OnCreate;
import com.example.cruise_company.controller.dto.group.OnUpdate;
import com.example.cruise_company.service.RouteService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RouteController implements RouteApi {

  private final RouteService routeService;

  @Override
  public List<RouteDto> getAllRoutes() {
    log.info(this.getClass().getSimpleName() + " getting all routes....");
    return routeService.getAllRoutes();
  }

  @Override
  public RouteDto getRoute(@PathVariable Integer id) {
    log.info(this.getClass().getSimpleName() + " getting route by id....");
    return routeService.getRoute(id);
  }

  @Override
  public RouteDto createRoute(@RequestBody @Validated(OnCreate.class) RouteDto routeDto) {
    log.info(this.getClass().getSimpleName() + " creating route....");
    return routeService.createRoute(routeDto);
  }

  @Override
  public RouteDto updateRoute(
      @PathVariable Integer id, @RequestBody @Validated(OnUpdate.class) RouteDto routeDto) {
    log.info(this.getClass().getSimpleName() + " updating route....");
    return routeService.updateRoute(id, routeDto);
  }

  @Override
  public ResponseEntity<Void> deleteRoute(@PathVariable Integer id) {
    log.info(this.getClass().getSimpleName() + " deleting route....");
    routeService.deleteRoute(id);
    return ResponseEntity.noContent().build();
  }
}
