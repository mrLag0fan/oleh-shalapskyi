package com.example.cruise_company.service.mapper;

import com.example.cruise_company.controller.dto.RouteDto;
import com.example.cruise_company.service.model.Route;
import com.example.cruise_company.service.repository.PortJpaRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class RouteMapper {

  @Autowired protected PortJpaRepository portRepository;

  @Mapping(target = "from", source = "route.from.id")
  @Mapping(target = "to", source = "route.to.id")
  public abstract RouteDto toDto(Route route);

  @Mapping(target = "from", expression = "java(portRepository.findById(routeDto.getFrom()).get())")
  @Mapping(target = "to", expression = "java(portRepository.findById(routeDto.getTo()).get())")
  public abstract Route toEntity(RouteDto routeDto);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "from", expression = "java(portRepository.findById(routeDto.getFrom()).get())")
  @Mapping(target = "to", expression = "java(portRepository.findById(routeDto.getTo()).get())")
  public abstract void update(@MappingTarget Route route, RouteDto routeDto);
}
