package com.example.cruise_company.controller;

import com.example.cruise_company.api.UserApi;
import com.example.cruise_company.controller.dto.UserDto;
import com.example.cruise_company.controller.dto.group.OnCreate;
import com.example.cruise_company.controller.dto.group.OnUpdate;
import com.example.cruise_company.service.UserService;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

  private final UserService userService;

  @Override
  public List<UserDto> getAllUsers(
      @PathVariable @Min(value = 0) Integer offset,
      @PathVariable @Min(value = 0) Integer limit,
      @RequestHeader String field,
      @RequestHeader String sortType) {
    log.info(this.getClass().getSimpleName() + " getting all users....");
    return userService.getAllUsers(offset, limit, field, sortType);
  }

  @Override
  public UserDto getUser(@PathVariable @Email String email) {
    log.info(this.getClass().getSimpleName() + " getting user by id....");
    return userService.getUser(email);
  }

  @Override
  public UserDto createUser(@RequestBody @Validated(OnCreate.class) UserDto userDto) {
    log.info(this.getClass().getSimpleName() + " creating user....");
    return userService.createUser(userDto);
  }

  @Override
  public UserDto updateUser(
      @PathVariable @Email String email, @RequestBody @Validated(OnUpdate.class) UserDto userDto) {
    log.info(this.getClass().getSimpleName() + " updating user....");
    return userService.updateUser(email, userDto);
  }

  @Override
  public ResponseEntity<Void> deleteUser(@PathVariable @Email String email) {
    log.info(this.getClass().getSimpleName() + " deleting user....");
    userService.deleteUser(email);
    return ResponseEntity.noContent().build();
  }
}
