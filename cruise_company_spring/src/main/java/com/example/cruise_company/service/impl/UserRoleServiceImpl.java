package com.example.cruise_company.service.impl;

import com.example.cruise_company.controller.dto.UserRoleDto;
import com.example.cruise_company.service.UserRoleService;
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
  public UserRoleDto getUserRoleById(Integer id) {
    log.info("get User Role by id {}", id);
    UserRole userRole = repository.getUserRole(id);
    return mapUserRoleToUserRoleDto(userRole);
  }

  @Override
  public List<UserRoleDto> getAllUserRoles() {
    log.info("get all user roles");
    return repository.getAllUserRoles().stream()
        .map(this::mapUserRoleToUserRoleDto)
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
    UserRole userRole = mapUserRoleDtoToUserRole(userRoleDto);
    userRole = repository.createUserRole(userRole);
    return mapUserRoleToUserRoleDto(userRole);
  }

  @Override
  public UserRoleDto updateUserRole(Integer id, UserRoleDto userRoleDto) {
    log.info("update user role with id {}", id);
    UserRole userRole = mapUserRoleDtoToUserRole(userRoleDto);
    userRole = repository.updateUserRole(id, userRole);
    return mapUserRoleToUserRoleDto(userRole);
  }

  private UserRoleDto mapUserRoleToUserRoleDto(UserRole userRole) {
    return UserRoleDto.builder().id(userRole.getId()).name(userRole.getName()).build();
  }

  private UserRole mapUserRoleDtoToUserRole(UserRoleDto userRoleDto) {
    return UserRole.builder().id(userRoleDto.getId()).name(userRoleDto.getName()).build();
  }
}
