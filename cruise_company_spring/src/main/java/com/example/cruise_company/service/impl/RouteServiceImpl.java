package com.example.cruise_company.service.impl;

import com.example.cruise_company.controller.dto.RouteDto;
import com.example.cruise_company.exception.entity_not_found.ReceiptNotFoundException;
import com.example.cruise_company.exception.entity_not_found.RouteNotFoundException;
import com.example.cruise_company.service.RouteService;
import com.example.cruise_company.service.mapper.RouteMapper;
import com.example.cruise_company.service.model.Route;
import com.example.cruise_company.service.other.GetAllService;
import com.example.cruise_company.service.repository.RouteJpaRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RouteServiceImpl implements RouteService {

  private final RouteJpaRepository routeRepository;
  private final RouteMapper routeMapper;

  @Override
  public RouteDto getRoute(Integer id) {
    log.info("get Route with id {}", id);
    Route route = routeRepository.findById(id).orElseThrow(ReceiptNotFoundException::new);
    return routeMapper.toDto(route);
  }

  @Override
  public List<RouteDto> getAllRoutes(Integer offset, Integer limit, String field, String sortType) {
    log.info("get all routes");
    Pageable page = GetAllService.getSortedPage(offset, limit, field, sortType);
    return routeRepository.findAll(page).stream()
        .map(routeMapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public void deleteRoute(Integer id) {
    log.info("Route delete by  id {}", id);
    routeRepository.findById(id).orElseThrow(ReceiptNotFoundException::new);
    routeRepository.deleteById(id);
  }

  @Override
  public RouteDto createRoute(RouteDto routeDto) {
    log.info(
        "create Route with from port " + "id {} and to port id {}",
        routeDto.getFrom(),
        routeDto.getTo());
    Route route = routeMapper.toEntity(routeDto);
    route = routeRepository.save(route);
    return routeMapper.toDto(route);
  }

  @Override
  public RouteDto updateRoute(Integer id, RouteDto routeDto) {
    log.info("update Route with id {}", id);
    Route persistedRoute = routeRepository.findById(id).orElseThrow(RouteNotFoundException::new);
    routeMapper.update(persistedRoute, routeDto);
    return routeMapper.toDto(persistedRoute);
  }
}
