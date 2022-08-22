package com.example.cruise_company.service;

import com.example.cruise_company.controller.dto.UserDto;
import java.util.List;

public interface UserService {

  UserDto getUser(String email);

  List<UserDto> getAllUsers(Integer offset, Integer limit, String field, String sortType);

  void deleteUser(String email);

  UserDto createUser(UserDto userDto);

  UserDto updateUser(String email, UserDto userDto);
}
