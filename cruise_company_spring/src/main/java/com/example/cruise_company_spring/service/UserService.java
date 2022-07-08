package com.example.cruise_company_spring.service;


import com.example.cruise_company_spring.controller.dto.UserDto;
import java.util.List;

public interface UserService {

    UserDto getUser(String email);

    List<UserDto> getAllUsers();

    boolean deleteUser(String email);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(String email, UserDto userDto);
}
