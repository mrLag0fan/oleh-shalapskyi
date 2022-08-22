package com.example.cruise_company.service.mapper;

import com.example.cruise_company.controller.dto.UserRoleDto;
import com.example.cruise_company.service.model.UserRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserRoleMapper {

  UserRoleMapper INSTANCE = Mappers.getMapper(UserRoleMapper.class);

  UserRoleDto toDto(UserRole userRole);

  UserRole toEntity(UserRoleDto userRoleDto);

  @Mapping(target = "id", ignore = true)
  void update(@MappingTarget UserRole userRole, UserRoleDto userRoleDto);
}
