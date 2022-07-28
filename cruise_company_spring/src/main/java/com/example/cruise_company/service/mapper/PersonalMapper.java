package com.example.cruise_company.service.mapper;

import com.example.cruise_company.controller.dto.PersonalDto;
import com.example.cruise_company.service.model.Personal;
import com.example.cruise_company.service.repository.LinerRepository;
import com.example.cruise_company.service.repository.PersonalRoleRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class PersonalMapper {

  @Autowired protected LinerRepository linerRepository;

  @Autowired protected PersonalRoleRepository personalRoleRepository;

  @Mapping(
      target = "fullName",
      expression = "java(personal.getName() + \" \" + personal.getSurname())")
  @Mapping(target = "linerId", source = "personal.liner.id")
  @Mapping(target = "personalRoleId", source = "personal.personalRole.id")
  public abstract PersonalDto toDto(Personal personal);

  @Mapping(target = "name", expression = "java(personalDto.getFullName().split(\" \")[0])")
  @Mapping(target = "surname", expression = "java(personalDto.getFullName().split(\" \")[1])")
  @Mapping(
      target = "liner",
      expression = "java(linerRepository.getLiner(personalDto.getLinerId()))")
  @Mapping(
      target = "personalRole",
      expression = "java(personalRoleRepository.getPersonalRole(personalDto.getPersonalRoleId()))")
  public abstract Personal toEntity(PersonalDto personalDto);
}
