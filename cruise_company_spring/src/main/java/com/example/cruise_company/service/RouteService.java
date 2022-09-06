package com.example.cruise_company.service;

import com.example.cruise_company.controller.dto.RouteDto;
import java.util.List;

public interface RouteService {
  RouteDto getRoute(Integer id);

  List<RouteDto> getAllRoutes(Integer offset, Integer limit, String field, String sortType);

  void deleteRoute(Integer id);

  RouteDto createRoute(RouteDto routeDto);

  RouteDto updateRoute(Integer id, RouteDto routeDto);
}
