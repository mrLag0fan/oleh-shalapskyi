package com.example.cruise_company.service.mapper;

import com.example.cruise_company.controller.dto.UserDto;
import com.example.cruise_company.service.model.User;
import com.example.cruise_company.service.repository.UserRoleJpaRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class UserMapper {

  @Autowired UserRoleJpaRepository userRoleRepository;

  @Mapping(target = "repeatPassword", source = "user.password")
  @Mapping(target = "userRoleId", source = "user.userRole.id")
  public abstract UserDto toDto(User user);

  @Mapping(
      target = "userRole",
      expression = "java(userRoleRepository.getById(userDto.getUserRoleId()))")
  public abstract User toEntity(UserDto userDto);

  @Mapping(target = "id", ignore = true)
  public abstract void update(@MappingTarget User user, UserDto userDto);
}
