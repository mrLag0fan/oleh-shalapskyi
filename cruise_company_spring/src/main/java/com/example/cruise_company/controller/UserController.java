package com.example.cruise_company.controller;

import com.example.cruise_company.controller.dto.UserDto;
import com.example.cruise_company.service.UserService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

  private final UserService userService;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping
  public List<UserDto> getAllUsers() {
    log.info(this.getClass().getSimpleName() + " getting all users....");
    return userService.getAllUsers();
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/{email}")
  public UserDto getUser(@PathVariable String email) {
    log.info(this.getClass().getSimpleName() + " getting user by id....");
    return userService.getUserById(email);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public UserDto createUser(@RequestBody UserDto userDto) {
    log.info(this.getClass().getSimpleName() + " creating user....");
    return userService.createUser(userDto);
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = "/{email}")
  public UserDto updateUser(@PathVariable String email, @RequestBody UserDto userDto) {
    log.info(this.getClass().getSimpleName() + " updating user....");
    return userService.updateUser(email, userDto);
  }

  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping(value = "/{email}")
  public ResponseEntity<Void> deleteUser(@PathVariable String email) {
    log.info(this.getClass().getSimpleName() + " deleting user....");
    userService.deleteUser(email);
    return ResponseEntity.noContent().build();
  }
}
