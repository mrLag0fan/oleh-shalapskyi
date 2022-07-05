package com.example.cruise_company_spring.service;

import com.example.cruise_company_spring.controller.dto.PersonalRoleDto;

import java.util.List;

public interface PersonalRoleService {

    PersonalRoleDto getPersonalRole(Integer id);
    List<PersonalRoleDto> getAllPersonalRoles();
    boolean deletePersonalRole(Integer id);
    PersonalRoleDto createPersonalRole(PersonalRoleDto personalRoleDto);
    PersonalRoleDto updatePersonalRole(Integer id, PersonalRoleDto personalRoleDto);

}
