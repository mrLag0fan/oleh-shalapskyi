package com.example.cruise_company.service.impl;

import com.example.cruise_company.controller.dto.UserDto;
import com.example.cruise_company.service.UserService;
import com.example.cruise_company.service.mapper.UserMapper;
import com.example.cruise_company.service.model.User;
import com.example.cruise_company.service.repository.UserRepository;
import com.example.cruise_company.service.repository.UserRoleRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserRoleRepository userRoleRepository;
  private final UserMapper userMapper;

  @Override
  public UserDto getUser(String email) {
    log.info("get User by email {}", email);
    User user = userRepository.getUser(email);
    return userMapper.toDto(user);
  }

  @Override
  public List<UserDto> getAllUsers() {
    log.info("get all users");
    return userRepository.getAllUsers().stream()
        .map(userMapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  public boolean deleteUser(String email) {
    log.info("user delete by email {}", email);
    return userRepository.deleteUser(email);
  }

  @Override
  public UserDto createUser(UserDto userDto) {
    log.info("create user with email {}", userDto.getEmail());
    User user = userMapper.toEntity(userDto);
    user.setUserRole(userRoleRepository.getUserRole(userDto.getUserRoleId()));
    user = userRepository.createUser(user);
    return userMapper.toDto(user);
  }

  @Override
  public UserDto updateUser(String email, UserDto userDto) {
    log.info("update user with email {}", email);
    User user = userMapper.toEntity(userDto);

    User oldUser = userRepository.getUser(email);
    user.setEmail(oldUser.getEmail());
    user.setUserRole(oldUser.getUserRole());

    user = userRepository.updateUser(email, user);
    return userMapper.toDto(user);
  }
}
