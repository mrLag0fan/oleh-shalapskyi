package com.example.cruise_company.service;

import com.example.cruise_company.controller.dto.UserRoleDto;
import java.util.List;

public interface UserRoleService {

  UserRoleDto getUserRole(Integer id);

  List<UserRoleDto> getAllUserRoles(Integer offset, Integer limit, String field, String sortType);

  void deleteUserRole(Integer id);

  UserRoleDto createUserRole(UserRoleDto userRoleDto);

  UserRoleDto updateUserRole(Integer id, UserRoleDto userRoleDto);
}
