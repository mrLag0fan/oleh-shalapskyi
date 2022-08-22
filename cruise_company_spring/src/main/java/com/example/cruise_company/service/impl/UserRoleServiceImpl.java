package com.example.cruise_company.service.impl;

import com.example.cruise_company.controller.dto.UserRoleDto;
import com.example.cruise_company.exception.entity_not_found.UserRoleNotFoundException;
import com.example.cruise_company.service.UserRoleService;
import com.example.cruise_company.service.mapper.UserRoleMapper;
import com.example.cruise_company.service.model.UserRole;
import com.example.cruise_company.service.other.GetAllService;
import com.example.cruise_company.service.repository.UserRoleJpaRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {

  private final UserRoleJpaRepository repository;

  @Override
  public UserRoleDto getUserRole(Integer id) {
    log.info("get User Role by id {}", id);
    UserRole userRole = repository.findById(id).orElseThrow(UserRoleNotFoundException::new);
    return UserRoleMapper.INSTANCE.toDto(userRole);
  }

  @Override
  public List<UserRoleDto> getAllUserRoles(
      Integer offset, Integer limit, String field, String sortType) {
    log.info("get all user roles");
    Pageable page = GetAllService.getSortedPage(offset, limit, field, sortType);
    return repository.findAll(page).stream()
        .map(UserRoleMapper.INSTANCE::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public void deleteUserRole(Integer id) {
    log.info("user role delete by id {}", id);
    repository.findById(id).orElseThrow(UserRoleNotFoundException::new);
    repository.deleteById(id);
  }

  @Override
  public UserRoleDto createUserRole(UserRoleDto userRoleDto) {
    log.info("create user role with id {}", userRoleDto.getId());
    UserRole userRole = UserRoleMapper.INSTANCE.toEntity(userRoleDto);
    userRole = repository.save(userRole);
    return UserRoleMapper.INSTANCE.toDto(userRole);
  }

  @Override
  public UserRoleDto updateUserRole(Integer id, UserRoleDto userRoleDto) {
    log.info("update user role with id {}", id);
    UserRole persistedUserRole =
        repository.findById(id).orElseThrow(UserRoleNotFoundException::new);
    UserRoleMapper.INSTANCE.update(persistedUserRole, userRoleDto);
    return UserRoleMapper.INSTANCE.toDto(persistedUserRole);
  }
}
