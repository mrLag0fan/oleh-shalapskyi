package com.example.cruise_company.service.impl;

import com.example.cruise_company.controller.dto.PersonalRoleDto;
import com.example.cruise_company.exception.entity_not_found.PersonalRoleNotFoundException;
import com.example.cruise_company.service.PersonalRoleService;
import com.example.cruise_company.service.mapper.PersonalRoleMapper;
import com.example.cruise_company.service.model.PersonalRole;
import com.example.cruise_company.service.other.GetAllService;
import com.example.cruise_company.service.repository.PersonalRoleJpaRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonalRoleServiceImpl implements PersonalRoleService {

  private final PersonalRoleJpaRepository repository;

  @Override
  public PersonalRoleDto getPersonalRole(Integer id) {
    log.info("get Personal Role by id {}", id);
    PersonalRole personalRole =
        repository.findById(id).orElseThrow(PersonalRoleNotFoundException::new);
    return PersonalRoleMapper.INSTANCE.toDto(personalRole);
  }

  @Override
  public List<PersonalRoleDto> getAllPersonalRoles(
      Integer offset, Integer limit, String field, String sortType) {
    log.info("get all personal roles");
    Pageable page = GetAllService.getSortedPage(offset, limit, field, sortType);
    return repository.findAll(page).stream()
        .map(PersonalRoleMapper.INSTANCE::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public void deletePersonalRole(Integer id) {
    log.info("personal role delete by id {}", id);
    repository.findById(id).orElseThrow(PersonalRoleNotFoundException::new);
    repository.deleteById(id);
  }

  @Override
  public PersonalRoleDto createPersonalRole(PersonalRoleDto personalRoleDto) {
    log.info("create personal role with id {}", personalRoleDto.getId());
    PersonalRole personalRole = PersonalRoleMapper.INSTANCE.toEntity(personalRoleDto);
    personalRole = repository.save(personalRole);
    return PersonalRoleMapper.INSTANCE.toDto(personalRole);
  }

  @Override
  public PersonalRoleDto updatePersonalRole(Integer id, PersonalRoleDto personalRoleDto) {
    log.info("update personal role with id {}", id);
    PersonalRole persisted =
        repository.findById(id).orElseThrow(PersonalRoleNotFoundException::new);
    PersonalRoleMapper.INSTANCE.update(persisted, personalRoleDto);
    return PersonalRoleMapper.INSTANCE.toDto(persisted);
  }
}
