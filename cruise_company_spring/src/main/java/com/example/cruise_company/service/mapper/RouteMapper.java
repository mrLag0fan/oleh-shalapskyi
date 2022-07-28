package com.example.cruise_company.service.mapper;

import com.example.cruise_company.controller.dto.RouteDto;
import com.example.cruise_company.service.model.Route;
import com.example.cruise_company.service.repository.PortRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class RouteMapper {

  @Autowired protected PortRepository portRepository;

  @Mapping(target = "from", source = "route.from.id")
  @Mapping(target = "to", source = "route.to.id")
  public abstract RouteDto toDto(Route route);

  @Mapping(target = "from", expression = "java(portRepository.getPort(routeDto.getFrom()))")
  @Mapping(target = "to", expression = "java(portRepository.getPort(routeDto.getTo()))")
  public abstract Route toEntity(RouteDto routeDto);
}
