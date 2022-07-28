package com.example.cruise_company.service.impl;

import com.example.cruise_company.controller.dto.UserRoleDto;
import com.example.cruise_company.service.UserRoleService;
import com.example.cruise_company.service.mapper.UserRoleMapper;
import com.example.cruise_company.service.model.UserRole;
import com.example.cruise_company.service.repository.UserRoleRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {

  private final UserRoleRepository repository;

  @Override
  public UserRoleDto getUserRole(Integer id) {
    log.info("get User Role by id {}", id);
    UserRole userRole = repository.getUserRole(id);
    return UserRoleMapper.INSTANCE.toDto(userRole);
  }

  @Override
  public List<UserRoleDto> getAllUserRoles() {
    log.info("get all user roles");
    return repository.getAllUserRoles().stream()
        .map(UserRoleMapper.INSTANCE::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public boolean deleteUserRole(Integer id) {
    log.info("user role delete by id {}", id);
    return repository.deleteUserRole(id);
  }

  @Override
  public UserRoleDto createUserRole(UserRoleDto userRoleDto) {
    log.info("create user role with id {}", userRoleDto.getId());
    UserRole userRole = UserRoleMapper.INSTANCE.toEntity(userRoleDto);
    userRole = repository.createUserRole(userRole);
    return UserRoleMapper.INSTANCE.toDto(userRole);
  }

  @Override
  public UserRoleDto updateUserRole(Integer id, UserRoleDto userRoleDto) {
    log.info("update user role with id {}", id);
    UserRole userRole = UserRoleMapper.INSTANCE.toEntity(userRoleDto);
    userRole.setId(id);
    userRole = repository.updateUserRole(id, userRole);
    return UserRoleMapper.INSTANCE.toDto(userRole);
  }
}
