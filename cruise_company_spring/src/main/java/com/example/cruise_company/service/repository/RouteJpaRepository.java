package com.example.cruise_company.service.repository;

import com.example.cruise_company.service.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteJpaRepository extends JpaRepository<Route, Integer> {}
