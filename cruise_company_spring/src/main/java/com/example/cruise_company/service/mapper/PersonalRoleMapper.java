package com.example.cruise_company.service.mapper;

import com.example.cruise_company.controller.dto.PersonalRoleDto;
import com.example.cruise_company.service.model.PersonalRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonalRoleMapper {

  PersonalRoleMapper INSTANCE = Mappers.getMapper(PersonalRoleMapper.class);

  PersonalRoleDto toDto(PersonalRole personalRole);

  PersonalRole toEntity(PersonalRoleDto personalRoleDto);

  @Mapping(target = "id", ignore = true)
  void update(@MappingTarget PersonalRole personalRole, PersonalRoleDto personalRoleDto);
}
