package com.example.cruise_company_spring.service.impl;

import com.example.cruise_company_spring.controller.dto.PersonalDto;
import com.example.cruise_company_spring.controller.dto.PersonalDto;
import com.example.cruise_company_spring.service.PersonalService;
import com.example.cruise_company_spring.service.model.Personal;
import com.example.cruise_company_spring.service.repository.LinerRepository;
import com.example.cruise_company_spring.service.repository.PersonalRepository;
import com.example.cruise_company_spring.service.repository.PersonalRoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class PersonalServiceImpl implements PersonalService {
    private final PersonalRepository personalRepository;
    private final PersonalRoleRepository personalRoleRepository;
    private final LinerRepository linerRepository;

    @Override
    public PersonalDto getPersonal(Integer id) {
        log.info("get Personal by id {}", id);
        Personal personal = personalRepository.getPersonal(id);
        return mapPersonalToPersonalDto(personal);
    }

    @Override
    public List<PersonalDto> getAllPersonals() {
        log.info("get all personals");
        return personalRepository.getAllPersonals()
                .stream()
                .map(this::mapPersonalToPersonalDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deletePersonal(Integer id) {
        log.info("personal delete by id {}", id);
        return personalRepository.deletePersonal(id);
    }

    @Override
    public PersonalDto createPersonal(Personal personal) {
        log.info("create personal with id {}", personal.getId());
        personalRepository.createPersonal(personal);
        return mapPersonalToPersonalDto(personal);
    }



    @Override
    public PersonalDto updatePersonal(Integer id, PersonalDto personalDto) {
        log.info("update personal with id {}", id);
        Personal personal = mapPersonalDtoToPersonal(personalDto);
        personal = personalRepository.updatePersonal(id, personal);
        return mapPersonalToPersonalDto(personal);
    }

    private PersonalDto mapPersonalToPersonalDto(Personal personal) {
        return PersonalDto.builder()
                .id(personal.getId())
                .fullName(personal.getName() + " " + personal.getSurname())
                .experience(personal.getExperience())
                .liner(linerRepository.getLiner(personal.getLinerId()))
                .personalRole(personalRoleRepository.getPersonalRole(personal.getPersonalRoleId()))
                .build();
    }

    private Personal mapPersonalDtoToPersonal(PersonalDto personalDto) {
        return Personal.builder()
                .id(personalDto.getId())
                .name(personalDto.getFullName().split(" ")[0])
                .surname(personalDto.getFullName().split(" ")[1])
                .experience(personalDto.getExperience())
                .linerId(personalDto.getLiner().getId())
                .personalRoleId(personalDto.getPersonalRole().getId())
                .build();
    }
}
