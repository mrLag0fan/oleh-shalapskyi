package com.example.cruise_company.controller;

import com.example.cruise_company.api.UserRoleApi;
import com.example.cruise_company.controller.dto.UserRoleDto;
import com.example.cruise_company.controller.dto.group.OnCreate;
import com.example.cruise_company.controller.dto.group.OnUpdate;
import com.example.cruise_company.service.UserRoleService;
import java.util.List;
import javax.validation.constraints.Min;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserRoleController implements UserRoleApi {

  private final UserRoleService userRoleService;

  @Override
  public List<UserRoleDto> getAllUserRoles(
      @Min(value = 0) Integer offset,
      @Min(value = 0) Integer limit,
      String field,
      String sortType) {
    log.info(this.getClass().getSimpleName() + " getting all user roles....");
    return userRoleService.getAllUserRoles(offset, limit, field, sortType);
  }

  @Override
  public UserRoleDto getUserRoleById(@PathVariable @Min(value = 1) Integer id) {
    log.info(this.getClass().getSimpleName() + " getting user role by id....");
    return userRoleService.getUserRole(id);
  }

  @Override
  public UserRoleDto createUserRole(
      @RequestBody @Validated(OnCreate.class) UserRoleDto userRoleDto) {
    log.info(this.getClass().getSimpleName() + " creating user role....");
    return userRoleService.createUserRole(userRoleDto);
  }

  @Override
  public UserRoleDto updateUserRole(
      @PathVariable @Min(value = 1) Integer id,
      @RequestBody @Validated(OnUpdate.class) UserRoleDto userRoleDto) {
    log.info(this.getClass().getSimpleName() + " updating user role....");
    return userRoleService.updateUserRole(id, userRoleDto);
  }

  @Override
  public ResponseEntity<Void> deleteUserRole(@PathVariable @Min(value = 1) Integer id) {
    log.info(this.getClass().getSimpleName() + " deleting user role....");
    userRoleService.deleteUserRole(id);
    return ResponseEntity.noContent().build();
  }
}
