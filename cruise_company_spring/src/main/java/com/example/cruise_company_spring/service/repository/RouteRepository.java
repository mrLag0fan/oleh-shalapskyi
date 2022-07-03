package com.example.cruise_company_spring.service.repository;

import com.example.cruise_company_spring.service.model.Route;

import java.util.List;

public interface RouteRepository {

    Route getRoute(Integer from, Integer to);
    List<Route> getAllRoutes();
    boolean deleteRoute(Integer from, Integer to);
    Route createRoute(Route user);
    Route updateRoute(Integer from, Integer to, Route user);

}
