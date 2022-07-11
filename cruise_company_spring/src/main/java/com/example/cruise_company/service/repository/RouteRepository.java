package com.example.cruise_company.service.repository;

import com.example.cruise_company.service.model.Route;
import java.util.List;

public interface RouteRepository {

  Route getRoute(Integer id);

  List<Route> getAllRoutes();

  boolean deleteRoute(Integer id);

  Route createRoute(Route user);

  Route updateRoute(Integer id, Route user);
}
