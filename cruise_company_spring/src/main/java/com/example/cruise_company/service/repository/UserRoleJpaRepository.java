package com.example.cruise_company.service.repository;

import com.example.cruise_company.service.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleJpaRepository extends JpaRepository<UserRole, Integer> {}
