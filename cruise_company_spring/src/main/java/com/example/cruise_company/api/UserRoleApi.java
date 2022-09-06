package com.example.cruise_company.api;

import com.example.cruise_company.controller.dto.UserRoleDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Api(tags = "UserRole API")
@RequestMapping("/api/v1/user_roles")
public interface UserRoleApi {

  @ApiOperation("Get all user role")
  @ResponseStatus(HttpStatus.OK)
  @ApiImplicitParams({
    @ApiImplicitParam(name = "offset", paramType = "query", value = "Offset", required = true),
    @ApiImplicitParam(name = "limit", paramType = "query", value = "Limit", required = true),
    @ApiImplicitParam(
        name = "field",
        paramType = "query",
        value = "Sort By",
        allowableValues = "id, name"),
    @ApiImplicitParam(
        name = "sortType",
        paramType = "query",
        value = "Sort By",
        allowableValues = "ASC, DESC")
  })
  @GetMapping
  List<UserRoleDto> getAllUserRoles(
      @RequestParam Integer offset,
      @RequestParam Integer limit,
      @RequestParam(required = false) String field,
      @RequestParam(required = false) String sortType);

  @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "UserRole id")
  @ApiOperation("Get user roles")
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/{id}")
  UserRoleDto getUserRoleById(@PathVariable Integer id);

  @ApiOperation("Create user role")
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  UserRoleDto createUserRole(@RequestBody UserRoleDto userRoleDto);

  @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "UserRole id")
  @ApiOperation("Update user role")
  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = "/{id}")
  UserRoleDto updateUserRole(@PathVariable Integer id, @RequestBody UserRoleDto userRoleDto);

  @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "UserRole id")
  @ApiOperation("Delete user role")
  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping(value = "/{id}")
  HttpStatus deleteUserRole(@PathVariable Integer id);

}
