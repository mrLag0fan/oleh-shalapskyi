package com.example.cruise_company_spring.service.repository.impl;

import com.example.cruise_company_spring.service.model.UserRole;
import com.example.cruise_company_spring.service.repository.UserRoleRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserRoleRepositoryListImpl implements UserRoleRepository {

	private final List<UserRole> list = new ArrayList<UserRole>();

	@Override
	public UserRole getUserRole(Integer id) {
		return list.stream().filter(userRole ->
				userRole.getId().equals(id))
			.findFirst()
			.orElseThrow(() ->
				new RuntimeException("User role not found"));
	}

	@Override
	public List<UserRole> getAllUserRoles() {
		return new ArrayList<>(list);
	}

	@Override
	public boolean deleteUserRole(Integer id) {
		return list.removeIf(userRole -> userRole.getId().equals(id));
	}

	@Override
	public UserRole createUserRole(UserRole userRole) {
		list.add(userRole);
		return userRole;
	}

	@Override
	public UserRole updateUserRole(Integer id, UserRole userRole) {
		if (list.removeIf(userRole1 -> userRole1.getId().equals(id))) {
			list.add(userRole);
		} else {
			throw new RuntimeException("User not found");
		}
		return userRole;
	}
}
