package com.example.cruise_company.service.impl;

import com.example.cruise_company.controller.dto.PersonalDto;
import com.example.cruise_company.exception.entity_not_found.PersonalNotFoundException;
import com.example.cruise_company.service.PersonalService;
import com.example.cruise_company.service.mapper.PersonalMapper;
import com.example.cruise_company.service.model.Personal;
import com.example.cruise_company.service.other.GetAllService;
import com.example.cruise_company.service.repository.PersonalJpaRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonalServiceImpl implements PersonalService {

  private final PersonalJpaRepository personalRepository;
  private final PersonalMapper personalMapper;

  @Override
  public PersonalDto getPersonal(Integer id) {
    log.info("get Personal by id {}", id);
    Personal personal = personalRepository.findById(id).orElseThrow(PersonalNotFoundException::new);
    return personalMapper.toDto(personal);
  }

  @Override
  public List<PersonalDto> getAllPersonals(
      Integer offset, Integer limit, String field, String sortType) {
    log.info("get all personals");
    Pageable page = GetAllService.getSortedPage(offset, limit, field, sortType);
    return personalRepository.findAll(page).stream()
        .map(personalMapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public void deletePersonal(Integer id) {
    log.info("personal delete by id {}", id);
    personalRepository.findById(id).orElseThrow(PersonalNotFoundException::new);
    personalRepository.deleteById(id);
  }

  @Override
  public PersonalDto createPersonal(Personal personal) {
    log.info("create personal with id {}", personal.getId());
    personalRepository.save(personal);
    return personalMapper.toDto(personal);
  }

  @Override
  public PersonalDto updatePersonal(Integer id, PersonalDto personalDto) {
    log.info("update personal with id {}", id);
    Personal persisted =
        personalRepository.findById(id).orElseThrow(PersonalNotFoundException::new);
    personalMapper.update(persisted, personalDto);
    return personalMapper.toDto(persisted);
  }
}
