package com.example.cruise_company.api;

import com.example.cruise_company.controller.dto.UserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import java.util.List;
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

@Api(tags = "User API")
@RequestMapping("/api/v1/users")
public interface UserApi {

  @ApiOperation("Get all user")
  @ResponseStatus(HttpStatus.OK)
  @GetMapping
  List<UserDto> getAllUsers();

  @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email")
  @ApiOperation("Get users")
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/{email}")
  UserDto getUserByEmail(@PathVariable String email);

  @ApiOperation("Create user")
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  UserDto createUser(@RequestBody UserDto userDto);

  @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email")
  @ApiOperation("Update user")
  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = "/{email}")
  UserDto updateUser(@PathVariable String email, @RequestBody UserDto userDto);

  @ApiImplicitParam(name = "email", paramType = "path", required = true, value = "User email")
  @ApiOperation("Delete user")
  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping(value = "/{email}")
  HttpStatus deleteUser(@PathVariable String email);
}
