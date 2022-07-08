package com.example.cruise_company_spring.service.repository;

import com.example.cruise_company_spring.service.model.Personal;
import java.util.List;

public interface PersonalRepository {

    Personal getPersonal(Integer id);

    List<Personal> getAllPersonals();

    boolean deletePersonal(Integer id);

    Personal createPersonal(Personal personal);

    Personal updatePersonal(Integer id, Personal personal);
}
