package com.example.cruise_company_spring.service.repository;

import com.example.cruise_company_spring.service.model.PersonalRole;

import java.util.List;

public interface PersonalRoleRepository {

    PersonalRole getPersonalRole(Integer id);
    List<PersonalRole> getAllPersonalRoles();
    boolean deletePersonalRole(Integer id);
    PersonalRole createPersonalRole(PersonalRole personalRole);
    PersonalRole updatePersonalRole(Integer id, PersonalRole personalRole);

}
