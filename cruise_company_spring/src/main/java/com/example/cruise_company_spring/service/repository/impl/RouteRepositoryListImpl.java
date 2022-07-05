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
    public Route getRoute(Integer id) {
        return list.stream()
                .filter(route -> route.getId().equals(id)).
                findFirst()
                .orElseThrow(() -> new RuntimeException("Route not found")) ;
    }

    @Override
    public List<Route> getAllRoutes() {
        return new ArrayList<>(list);
    }

    @Override
    public boolean deleteRoute(Integer id){
        return list.removeIf(route -> route.getId().equals(id));
    }

    @Override
    public Route createRoute(Route route) {
        list.add(route);
        return route;
    }

    @Override
    public Route updateRoute(Integer id, Route route) {
        if (list.removeIf(route1 -> route1.getId().equals(id))){
            list.add(route);
        }else {
            throw new RuntimeException("Route not found");
        }
        return route;
    }
}
