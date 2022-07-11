package com.example.cruise_company.service.repository;

import com.example.cruise_company.service.model.Personal;
import java.util.List;

public interface PersonalRepository {

  Personal getPersonal(Integer id);

  List<Personal> getAllPersonals();

  boolean deletePersonal(Integer id);

  Personal createPersonal(Personal personal);

  Personal updatePersonal(Integer id, Personal personal);
}
