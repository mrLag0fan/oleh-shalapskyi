package com.example.cruise_company.service;

import com.example.cruise_company.controller.dto.UserRoleDto;
import java.util.List;

public interface UserRoleService {

  UserRoleDto getUserRoleById(Integer id);

  List<UserRoleDto> getAllUserRoles();

  boolean deleteUserRole(Integer id);

  UserRoleDto createUserRole(UserRoleDto userRoleDto);

  UserRoleDto updateUserRole(Integer id, UserRoleDto userRoleDto);
}
