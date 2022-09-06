package com.example.cruise_company.service.mapper;

import com.example.cruise_company.controller.dto.LinerDto;
import com.example.cruise_company.service.model.Liner;
import com.example.cruise_company.service.repository.PortJpaRepository;
import com.example.cruise_company.service.repository.RouteJpaRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class LinerMapper {

  @Autowired protected PortJpaRepository portRepository;
  @Autowired protected RouteJpaRepository routeRepository;

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
      expression = "java(portRepository.findById(linerDto.getStartPortId()).get())")
  @Mapping(
      target = "endPort",
      expression = "java(portRepository.findById(linerDto.getEndPortId()).get())")
  @Mapping(
      target = "routes",
      expression =
          "java(java.util.Arrays.stream(linerDto.getRoutes())"
              + ".map(i -> routeRepository.findById(i).get())"
              + ".collect(java.util.stream.Collectors.toList()))")
  public abstract Liner toEntity(LinerDto linerDto);

  @Mapping(target = "id", ignore = true)
  @Mapping(
      target = "startPort",
      expression = "java(portRepository.findById(linerDto.getStartPortId()).get())")
  @Mapping(
      target = "endPort",
      expression = "java(portRepository.findById(linerDto.getEndPortId()).get())")
  @Mapping(
      target = "routes",
      expression =
          "java(java.util.Arrays.stream(linerDto.getRoutes())"
              + ".map(i -> routeRepository.findById(i).get())"
              + ".collect(java.util.stream.Collectors.toList()))")
  public abstract void update(@MappingTarget Liner liner, LinerDto linerDto);
}
