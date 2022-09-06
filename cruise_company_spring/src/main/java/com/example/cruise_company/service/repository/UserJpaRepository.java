package com.example.cruise_company.service.repository;

import com.example.cruise_company.service.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

  Optional<Void> deleteByEmail(String email);

  boolean existsByEmail(String email);
}
