package com.example.cruise_company.service;

import com.example.cruise_company.controller.dto.UserDto;
import java.util.List;

public interface UserService {

  UserDto getUserById(String email);

  List<UserDto> getAllUsers();

  boolean deleteUser(String email);

  UserDto createUser(UserDto userDto);

  UserDto updateUser(String email, UserDto userDto);
}
