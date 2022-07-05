package com.example.cruise_company_spring.service;

import com.example.cruise_company_spring.controller.dto.UserRoleDto;
import com.example.cruise_company_spring.service.model.UserRole;

import java.util.List;

public interface UserRoleService {

    UserRoleDto getUserRole(Integer id);
    List<UserRoleDto> getAllUserRoles();
    boolean deleteUserRole(Integer id);
    UserRoleDto createUserRole(UserRoleDto userRoleDto);
    UserRoleDto updateUserRole(Integer id, UserRoleDto userRoleDto);

}
