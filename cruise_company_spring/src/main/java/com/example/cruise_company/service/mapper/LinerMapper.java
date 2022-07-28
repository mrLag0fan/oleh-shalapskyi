package com.example.cruise_company.service.mapper;

import com.example.cruise_company.controller.dto.LinerDto;
import com.example.cruise_company.service.model.Liner;
import com.example.cruise_company.service.repository.PortRepository;
import com.example.cruise_company.service.repository.RouteRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class LinerMapper {

  @Autowired protected PortRepository portRepository;
  @Autowired protected RouteRepository routeRepository;

  @Mapping(target = "startPortId", source = "liner.startPort.id")
  @Mapping(target = "endPortId", source = "liner.endPort.id")
  @Mapping(
      target = "routes",
      expression =
          "java(liner.getRoutes().stream()"
              + ".map(com.example.cruise_company.service.model.Route::getId)"
              + ".toArray(Integer[]::new))")
  public abstract LinerDto toDto(Liner liner);

  @Mapping(
      target = "startPort",
      expression = "java(portRepository.getPort(linerDto.getStartPortId()))")
  @Mapping(target = "endPort", expression = "java(portRepository.getPort(linerDto.getEndPortId()))")
  @Mapping(
      target = "routes",
      expression =
          "java(java.util.Arrays.stream(linerDto.getRoutes())"
              + ".map(routeRepository::getRoute).collect(java.util.stream.Collectors.toList()))")
  public abstract Liner toEntity(LinerDto linerDto);
}
