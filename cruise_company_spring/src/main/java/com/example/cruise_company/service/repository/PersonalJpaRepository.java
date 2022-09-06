package com.example.cruise_company.service.repository;

import com.example.cruise_company.service.model.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalJpaRepository extends JpaRepository<Personal, Integer> {}
