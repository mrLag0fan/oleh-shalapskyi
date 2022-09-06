package com.example.cruise_company.service.impl;

import com.example.cruise_company.controller.dto.UserDto;
import com.example.cruise_company.exception.entity_already_exists.UserAlreadyExists;
import com.example.cruise_company.exception.entity_not_found.UserNotFoundException;
import com.example.cruise_company.service.UserService;
import com.example.cruise_company.service.mapper.UserMapper;
import com.example.cruise_company.service.model.User;
import com.example.cruise_company.service.other.GetAllService;
import com.example.cruise_company.service.repository.UserJpaRepository;
import java.util.List;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {

  private final UserJpaRepository userRepository;
  private final UserMapper userMapper;

  @Override
  public UserDto getUser(String email) {
    log.info("get User by email {}", email);
    User user = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
    return userMapper.toDto(user);
  }

  @Override
  public List<UserDto> getAllUsers(Integer offset, Integer limit, String field, String sortType) {
    log.info("get all users");
    Pageable page = GetAllService.getSortedPage(offset, limit, field, sortType);
    return userRepository.findAll(page).stream()
        .map(userMapper::toDto)
        .collect(Collectors.toList());
  }

  @Override
  @Transactional
  public void deleteUser(String email) {
    log.info("user delete by email {}", email);
    userRepository.deleteByEmail(email).orElseThrow(UserNotFoundException::new);
  }

  @Override
  @Transactional
  public UserDto createUser(UserDto userDto) {
    log.info("create user with email {}", userDto.getEmail());
    if (userRepository.existsByEmail(userDto.getEmail())) {
      throw new UserAlreadyExists();
    }
    User user = userMapper.toEntity(userDto);
    user = userRepository.save(user);
    return userMapper.toDto(user);
  }

  @Override
  @Transactional
  public UserDto updateUser(String email, UserDto userDto) {
    log.info("update user with email {}", email);
    User persistedUser = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
    userMapper.update(persistedUser, userDto);
    return userMapper.toDto(persistedUser);
  }
}
