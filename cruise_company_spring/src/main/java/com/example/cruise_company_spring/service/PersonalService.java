package com.example.cruise_company_spring.service;

import com.example.cruise_company_spring.controller.dto.PersonalDto;
import com.example.cruise_company_spring.service.model.Personal;
import java.util.List;

public interface PersonalService {

    PersonalDto getPersonal(Integer id);

    List<PersonalDto> getAllPersonals();

    boolean deletePersonal(Integer id);

    PersonalDto createPersonal(Personal personal);

    PersonalDto updatePersonal(Integer id, PersonalDto personalDto);
}
