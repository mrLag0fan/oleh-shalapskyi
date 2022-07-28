package com.example.cruise_company.service.impl;

import com.example.cruise_company.controller.dto.RouteDto;
import com.example.cruise_company.service.RouteService;
import com.example.cruise_company.service.mapper.RouteMapper;
import com.example.cruise_company.service.model.Route;
import com.example.cruise_company.service.repository.RouteRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {

  private final RouteRepository routeRepository;
  private final RouteMapper routeMapper;

  @Override
  public RouteDto getRoute(Integer id) {
    log.info("get Route with id {}", id);
    Route route = routeRepository.getRoute(id);
    return routeMapper.toDto(route);
  }

  @Override
  public List<RouteDto> getAllRoutes() {
    log.info("get all routes");
    return routeRepository.getAllRoutes().stream()
        .map(routeMapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public boolean deleteRoute(Integer id) {
    log.info("Route delete by  id {}", id);
    return routeRepository.deleteRoute(id);
  }

  @Override
  public RouteDto createRoute(RouteDto routeDto) {
    log.info(
        "create Route with from port " + "id {} and to port id {}",
        routeDto.getFrom(),
        routeDto.getTo());
    Route route = routeMapper.toEntity(routeDto);
    route = routeRepository.createRoute(route);
    return routeMapper.toDto(route);
  }

  @Override
  public RouteDto updateRoute(Integer id, RouteDto routeDto) {
    log.info("update Route with id {}", id);
    Route route = routeMapper.toEntity(routeDto);
    route.setId(id);
    route = routeRepository.updateRoute(id, route);
    return routeMapper.toDto(route);
  }
}
