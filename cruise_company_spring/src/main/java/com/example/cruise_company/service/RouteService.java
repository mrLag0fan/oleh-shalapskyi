package com.example.cruise_company.service;

import com.example.cruise_company.controller.dto.RouteDto;
import com.example.cruise_company.service.model.Route;
import java.util.List;

public interface RouteService {
  RouteDto getRoute(Integer id);

  List<RouteDto> getAllRoutes();

  boolean deleteRoute(Integer id);

  RouteDto createRoute(Route route);

  RouteDto updateRoute(Integer id, RouteDto routeDto);
}
