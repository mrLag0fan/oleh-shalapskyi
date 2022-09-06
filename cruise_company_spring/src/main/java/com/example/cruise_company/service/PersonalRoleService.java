package com.example.cruise_company.service;

import com.example.cruise_company.controller.dto.PersonalRoleDto;
import java.util.List;

public interface PersonalRoleService {

  PersonalRoleDto getPersonalRole(Integer id);

  List<PersonalRoleDto> getAllPersonalRoles(
      Integer offset, Integer limit, String field, String sortType);

  void deletePersonalRole(Integer id);

  PersonalRoleDto createPersonalRole(PersonalRoleDto personalRoleDto);

  PersonalRoleDto updatePersonalRole(Integer id, PersonalRoleDto personalRoleDto);
}
