package com.example.cruise_company.service.repository.impl;

import com.example.cruise_company.service.model.User;
import com.example.cruise_company.service.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryListImpl implements UserRepository {

  private final List<User> list = new ArrayList<User>();

  @Override
  public User getUser(String email) {
    return list.stream()
        .filter(user -> user.getEmail().equals(email))
        .findFirst()
        .orElseThrow(() -> new RuntimeException("User not found"));
  }

  @Override
  public List<User> getAllUsers() {
    return new ArrayList<>(list);
  }

  @Override
  public boolean deleteUser(String email) {
    return list.removeIf(user -> user.getEmail().equals(email));
  }

  @Override
  public User createUser(User user) {
    list.add(user);
    return user;
  }

  @Override
  public User updateUser(String email, User user) {
    if (list.removeIf(user1 -> user1.getEmail().equals(email))) {
      list.add(user);
    } else {
      throw new RuntimeException("User not found");
    }
    return user;
  }
}
