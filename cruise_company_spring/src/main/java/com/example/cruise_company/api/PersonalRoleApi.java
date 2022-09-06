package com.example.cruise_company.api;

import com.example.cruise_company.controller.dto.PersonalRoleDto;
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

@Api(tags = "Personal Role API")
@RequestMapping("/api/v1/personalRoles")
public interface PersonalRoleApi {

  @ApiOperation("Get all personalRole")
  @ResponseStatus(HttpStatus.OK)
  @GetMapping
  List<PersonalRoleDto> getAllPersonalRoles();

  @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "PersonalRole id")
  @ApiOperation("Get personalRole")
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/{id}")
  PersonalRoleDto getPersonalRoleById(@PathVariable Integer id);

  @ApiOperation("Create personalRole")
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  PersonalRoleDto createPersonalRole(@RequestBody PersonalRoleDto personalRoleDto);

  @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "PersonalRole id")
  @ApiOperation("Update personalRole")
  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = "/{id}")
  PersonalRoleDto updatePersonalRole(
      @PathVariable Integer id, @RequestBody PersonalRoleDto personalRoleDto);

  @ApiImplicitParam(name = "id", paramType = "path", required = true, value = "PersonalRole id")
  @ApiOperation("Delete personalRole")
  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping(value = "/{id}")
  HttpStatus deletePersonalRole(@PathVariable Integer id);
}
