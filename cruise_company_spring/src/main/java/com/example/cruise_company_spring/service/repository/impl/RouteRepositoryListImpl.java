package com.example.cruise_company_spring.service.repository.impl;

import com.example.cruise_company_spring.service.model.Route;
import com.example.cruise_company_spring.service.model.Route;
import com.example.cruise_company_spring.service.repository.RouteRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RouteRepositoryListImpl implements RouteRepository {
    private final List<Route> list = new ArrayList<Route>();

    @Override
    public Route getRoute(Integer from, Integer to) {
        return list.stream()
                .filter(route -> route.getFrom().equals(from) && route.getTo().equals(to)).
                findFirst()
                .orElseThrow(() -> new RuntimeException("Route not found")) ;
    }

    @Override
    public List<Route> getAllRoutes() {
        return new ArrayList<>(list);
    }

    @Override
    public boolean deleteRoute(Integer from, Integer to) {
        return list.removeIf(route -> route.getFrom().equals(from) && route.getTo().equals(to));
    }

    @Override
    public Route createRoute(Route route) {
        list.add(route);
        return route;
    }

    @Override
    public Route updateRoute(Integer from, Integer to, Route route) {
        if (list.removeIf(route1 -> route1.getFrom().equals(from) && route1.getTo().equals(to))){
            list.add(route);
        }else {
            throw new RuntimeException("Route not found");
        }
        return route;
    }
}
