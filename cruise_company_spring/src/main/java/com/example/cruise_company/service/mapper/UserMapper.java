package com.example.cruise_company.service.mapper;

import com.example.cruise_company.controller.dto.UserDto;
import com.example.cruise_company.service.model.User;
import com.example.cruise_company.service.repository.UserRoleRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class UserMapper {

  @Autowired UserRoleRepository userRoleRepository;

  @Mapping(target = "repeatPassword", source = "user.password")
  @Mapping(target = "userRoleId", source = "user.userRole.id")
  public abstract UserDto toDto(User user);

  @Mapping(
      target = "userRole",
      expression = "java(userRoleRepository.getUserRole(userDto.getUserRoleId()))")
  public abstract User toEntity(UserDto userDto);
}
