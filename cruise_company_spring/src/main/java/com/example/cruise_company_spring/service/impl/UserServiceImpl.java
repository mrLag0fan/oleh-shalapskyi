package com.example.cruise_company_spring.service.impl;

import com.example.cruise_company_spring.controller.dto.UserDto;
import com.example.cruise_company_spring.service.UserService;
import com.example.cruise_company_spring.service.model.User;
import com.example.cruise_company_spring.service.repository.UserRepository;
import com.example.cruise_company_spring.service.repository.UserRoleRepository;
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

    @Override
    public UserDto getUser(String email) {
        log.info("get User by email {}", email);
        User user = userRepository.getUser(email);
        return mapUserToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        log.info("get all users");
        return userRepository.getAllUsers()
                .stream()
                .map(this::mapUserToUserDto)
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
        User user = mapUserDtoToUser(userDto);
        user = userRepository.createUser(user);
        return mapUserToUserDto(user);
    }

    @Override
    public UserDto updateUser(String email, UserDto userDto) {
        log.info("update user with email {}", email);
        User user = mapUserDtoToUser(userDto);
        user = userRepository.updateUser(email, user);
        return mapUserToUserDto(user);
    }

    private UserDto mapUserToUserDto(User user) {
        return UserDto.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .repeatPassword(user.getPassword())
                .balance(user.getBalance())
                .userRole(userRoleRepository.getUserRole(user.getUserRoleId()))
                .build();
    }

    private User mapUserDtoToUser(UserDto userDto) {
        return User.builder()
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .email(userDto.getEmail())
                .userRoleId(userDto.getUserRole().getId())
                .build();
    }
}
