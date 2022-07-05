package com.example.cruise_company_spring.service.impl;

import com.example.cruise_company_spring.controller.dto.RouteDto;
import com.example.cruise_company_spring.service.RouteService;
import com.example.cruise_company_spring.service.model.Route;
import com.example.cruise_company_spring.service.model.Route;
import com.example.cruise_company_spring.service.model.Route;
import com.example.cruise_company_spring.service.repository.PortRepository;
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
    private final PortRepository portRepository;

    @Override
    public RouteDto getRoute(Integer id) {
        log.info("get Route with id {}", id);
        Route route = routeRepository.getRoute(id);
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
    public boolean deleteRoute(Integer id) {
        log.info("Route delete by  id {}", id);
        return routeRepository.deleteRoute(id);
    }

    @Override
    public RouteDto createRoute(Route route) {
        log.info("create Route with from port id {} and to port id {}", route.getFrom(), route.getTo());
        routeRepository.createRoute(route);
        return mapRouteToRouteDto(route);
    }



    @Override
    public RouteDto updateRoute(Integer id, RouteDto routeDto) {
        log.info("update Route with id {}", id);
        Route port = mapRouteDtoToRoute(routeDto);
        port = routeRepository.updateRoute(id, port);
        return mapRouteToRouteDto(port);
    }

    private RouteDto mapRouteToRouteDto(Route route) {
        return RouteDto.builder()
                .from(portRepository.getPort(route.getFrom()))
                .to(portRepository.getPort(route.getTo()))
                .build();
    }

    private Route mapRouteDtoToRoute(RouteDto routeDto) {
        return Route.builder()
                .from(routeDto.getFrom().getId())
                .to(routeDto.getTo().getId())
                .build();
    }
}
