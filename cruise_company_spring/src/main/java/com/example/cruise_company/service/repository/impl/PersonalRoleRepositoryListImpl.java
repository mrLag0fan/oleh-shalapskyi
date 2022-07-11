package com.example.cruise_company.service.repository.impl;

import com.example.cruise_company.service.model.PersonalRole;
import com.example.cruise_company.service.repository.PersonalRoleRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PersonalRoleRepositoryListImpl implements PersonalRoleRepository {

  private final List<PersonalRole> list = new ArrayList<PersonalRole>();

  @Override
  public PersonalRole getPersonalRole(Integer id) {
    return list.stream()
        .filter(personalRole -> personalRole.getId().equals(id))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("Personal role not found"));
  }

  @Override
  public List<PersonalRole> getAllPersonalRoles() {
    return new ArrayList<>(list);
  }

  @Override
  public boolean deletePersonalRole(Integer id) {
    return list.removeIf(personalRole -> personalRole.getId().equals(id));
  }

  @Override
  public PersonalRole createPersonalRole(PersonalRole personalRole) {
    list.add(personalRole);
    return personalRole;
  }

  @Override
  public PersonalRole updatePersonalRole(Integer id, PersonalRole personalRole) {
    if (list.removeIf(personalRole1 -> personalRole1.getId().equals(id))) {
      list.add(personalRole);
    } else {
      throw new RuntimeException("Personal not found");
    }
    return personalRole;
  }
}
