package com.example.cruise_company_spring.service;

import com.example.cruise_company_spring.controller.dto.RouteDto;

import java.util.List;

public interface RouteService {
    RouteDto getRoute(Integer from, Integer to);
    List<RouteDto> getAllRoutes();
    boolean deleteRoute(Integer from, Integer to);
    RouteDto createRoute(RouteDto routeDto);
    RouteDto updateRoute(Integer from, Integer to, RouteDto routeDto);
}
