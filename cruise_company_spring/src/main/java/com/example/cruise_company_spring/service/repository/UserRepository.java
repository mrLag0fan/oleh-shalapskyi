package com.example.cruise_company_spring.service.repository;

import com.example.cruise_company_spring.service.model.User;
import java.util.List;

public interface UserRepository {

    User getUser(String email);

    List<User> getAllUsers();

    boolean deleteUser(String email);

    User createUser(User user);

    User updateUser(String email, User user);
}
