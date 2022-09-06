package com.example.cruise_company.service.repository.impl;

import com.example.cruise_company.exception.entity_not_found.PersonalNotFoundException;
import com.example.cruise_company.service.model.Personal;
import com.example.cruise_company.service.repository.PersonalRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PersonalRepositoryListImpl implements PersonalRepository {

  private final List<Personal> list = new ArrayList<Personal>();

  @Override
  public Personal getPersonal(Integer id) {
    return list.stream()
        .filter(personal -> personal.getId().equals(id))
        .findFirst()
        .orElseThrow(PersonalNotFoundException::new);
  }

  @Override
  public List<Personal> getAllPersonals() {
    return new ArrayList<>(list);
  }

  @Override
  public boolean deletePersonal(Integer id) {
    return list.removeIf(personal -> personal.getId().equals(id));
  }

  @Override
  public Personal createPersonal(Personal personal) {
    list.add(personal);
    return personal;
  }

  @Override
  public Personal updatePersonal(Integer id, Personal personal) {
    if (list.removeIf(personal1 -> personal1.getId().equals(id))) {
      list.add(personal);
    } else {
      throw new PersonalNotFoundException();
    }
    return personal;
  }
}
