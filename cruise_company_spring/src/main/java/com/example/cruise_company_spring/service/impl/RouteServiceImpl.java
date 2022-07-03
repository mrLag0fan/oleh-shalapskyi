package com.example.cruise_company_spring.service.impl;

import com.example.cruise_company_spring.controller.dto.RouteDto;
import com.example.cruise_company_spring.service.RouteService;
import com.example.cruise_company_spring.service.model.Route;
import com.example.cruise_company_spring.service.model.Route;
import com.example.cruise_company_spring.service.model.Route;
import com.example.cruise_company_spring.service.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;

    @Override
    public RouteDto getRoute(Integer from, Integer to) {
        log.info("get Route from port id {} to {}", from, to);
        Route route = routeRepository.getRoute(from, to);
        return mapRouteToRouteDto(route);
    }

    @Override
    public List<RouteDto> getAllRoutes() {
        log.info("get all routes");
        return routeRepository.getAllRoutes()
                .stream()
                .map(this::mapRouteToRouteDto)
                .collect(Collectors.toList());    }

    @Override
    public boolean deleteRoute(Integer from, Integer to) {
        log.info("Route delete by from port id {} and to port id {}", from, to);
        return routeRepository.deleteRoute(from, to);
    }

    @Override
    public RouteDto createRoute(RouteDto routeDto) {
        log.info("create Route with from port id {} and to port id {}", routeDto.getFrom(), routeDto.getTo());
        Route route = mapRouteDtoToRoute(routeDto);
        route = routeRepository.createRoute(route);
        return mapRouteToRouteDto(route);
    }



    @Override
    public RouteDto updateRoute(Integer from, Integer to, RouteDto routeDto) {
        log.info("update Route with from port id {} and to port id {}", from, to);
        Route port = mapRouteDtoToRoute(routeDto);
        port = routeRepository.updateRoute(from, to, port);
        return mapRouteToRouteDto(port);
    }

    private RouteDto mapRouteToRouteDto(Route route) {
        return RouteDto.builder()
                .from(route.getFrom())
                .to(route.getTo())
                .build();
    }

    private Route mapRouteDtoToRoute(RouteDto routeDto) {
        return Route.builder()
                .from(routeDto.getFrom())
                .to(routeDto.getTo())
                .build();
    }
}
