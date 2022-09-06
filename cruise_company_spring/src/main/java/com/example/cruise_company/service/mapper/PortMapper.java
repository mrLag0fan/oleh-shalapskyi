package com.example.cruise_company.service.mapper;

import com.example.cruise_company.controller.dto.PortDto;
import com.example.cruise_company.service.model.Port;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PortMapper {

  PortMapper INSTANCE = Mappers.getMapper(PortMapper.class);

  PortDto toDto(Port port);

  Port toEntity(PortDto portDto);

  @Mapping(target = "id", ignore = true)
  void update(@MappingTarget Port port, PortDto portDto);
}
