package com.example.cruise_company.service.impl;

import com.example.cruise_company.controller.dto.PersonalDto;
import com.example.cruise_company.service.PersonalService;
import com.example.cruise_company.service.mapper.PersonalMapper;
import com.example.cruise_company.service.model.Personal;
import com.example.cruise_company.service.repository.LinerRepository;
import com.example.cruise_company.service.repository.PersonalRepository;
import com.example.cruise_company.service.repository.PersonalRoleRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonalServiceImpl implements PersonalService {

  private final PersonalRepository personalRepository;
  private final PersonalRoleRepository personalRoleRepository;
  private final LinerRepository linerRepository;
  private final PersonalMapper personalMapper;

  @Override
  public PersonalDto getPersonal(Integer id) {
    log.info("get Personal by id {}", id);
    Personal personal = personalRepository.getPersonal(id);
    return personalMapper.toDto(personal);
  }

  @Override
  public List<PersonalDto> getAllPersonals() {
    log.info("get all personals");
    return personalRepository.getAllPersonals().stream()
        .map(personalMapper::toDto)
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
    return personalMapper.toDto(personal);
  }

  @Override
  public PersonalDto updatePersonal(Integer id, PersonalDto personalDto) {
    log.info("update personal with id {}", id);
    Personal personal = personalMapper.toEntity(personalDto);
    personal.setId(id);
    personal = personalRepository.updatePersonal(id, personal);
    return personalMapper.toDto(personal);
  }
}
