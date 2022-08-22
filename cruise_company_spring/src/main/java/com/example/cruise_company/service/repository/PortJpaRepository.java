package com.example.cruise_company.service.repository;

import com.example.cruise_company.service.model.Port;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortJpaRepository extends JpaRepository<Port, Integer> {}
