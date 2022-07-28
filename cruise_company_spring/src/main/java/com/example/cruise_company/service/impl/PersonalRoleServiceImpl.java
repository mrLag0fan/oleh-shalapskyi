package com.example.cruise_company.service.impl;

import com.example.cruise_company.controller.dto.PersonalRoleDto;
import com.example.cruise_company.service.PersonalRoleService;
import com.example.cruise_company.service.mapper.PersonalRoleMapper;
import com.example.cruise_company.service.model.PersonalRole;
import com.example.cruise_company.service.repository.PersonalRoleRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PersonalRoleServiceImpl implements PersonalRoleService {

  private final PersonalRoleRepository repository;

  @Override
  public PersonalRoleDto getPersonalRole(Integer id) {
    log.info("get Personal Role by id {}", id);
    PersonalRole personalRole = repository.getPersonalRole(id);
    return PersonalRoleMapper.INSTANCE.toDto(personalRole);
  }

  @Override
  public List<PersonalRoleDto> getAllPersonalRoles() {
    log.info("get all personal roles");
    return repository.getAllPersonalRoles().stream()
        .map(PersonalRoleMapper.INSTANCE::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public boolean deletePersonalRole(Integer id) {
    log.info("personal role delete by id {}", id);
    return repository.deletePersonalRole(id);
  }

  @Override
  public PersonalRoleDto createPersonalRole(PersonalRoleDto personalRoleDto) {
    log.info("create personal role with id {}", personalRoleDto.getId());
    PersonalRole personalRole = PersonalRoleMapper.INSTANCE.toEntity(personalRoleDto);
    personalRole = repository.createPersonalRole(personalRole);
    return PersonalRoleMapper.INSTANCE.toDto(personalRole);
  }

  @Override
  public PersonalRoleDto updatePersonalRole(Integer id, PersonalRoleDto personalRoleDto) {
    log.info("update personal role with id {}", id);
    PersonalRole personalRole = PersonalRoleMapper.INSTANCE.toEntity(personalRoleDto);
    personalRole.setId(id);
    personalRole = repository.updatePersonalRole(id, personalRole);
    return PersonalRoleMapper.INSTANCE.toDto(personalRole);
  }
}
