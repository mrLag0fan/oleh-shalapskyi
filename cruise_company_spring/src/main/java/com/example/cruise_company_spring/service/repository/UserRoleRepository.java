package com.example.cruise_company_spring.service.repository;

import com.example.cruise_company_spring.service.model.UserRole;
import java.util.List;

public interface UserRoleRepository {

    UserRole getUserRole(Integer id);

    List<UserRole> getAllUserRoles();

    boolean deleteUserRole(Integer id);

    UserRole createUserRole(UserRole userRole);

    UserRole updateUserRole(Integer id, UserRole userRole);
}
