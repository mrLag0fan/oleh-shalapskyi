package com.example.cruise_company.controller;

import com.example.cruise_company.api.PersonalRoleApi;
import com.example.cruise_company.controller.dto.PersonalRoleDto;
import com.example.cruise_company.controller.dto.group.OnCreate;
import com.example.cruise_company.controller.dto.group.OnUpdate;
import com.example.cruise_company.service.PersonalRoleService;
import java.util.List;
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
public class PersonalRoleController implements PersonalRoleApi {
  private final PersonalRoleService personalRoleService;

  @Override
  public List<PersonalRoleDto> getAllPersonalRoles() {
    log.info(this.getClass().getSimpleName() + " getting all personal role....");
    return personalRoleService.getAllPersonalRoles();
  }

  @Override
  public PersonalRoleDto getPersonalRoleById(@PathVariable Integer id) {
    log.info(this.getClass().getSimpleName() + " getting personal role by id....");
    return personalRoleService.getPersonalRole(id);
  }

  @Override
  public PersonalRoleDto createPersonalRole(
      @RequestBody @Validated(OnCreate.class) PersonalRoleDto personalRoleDto) {
    log.info(this.getClass().getSimpleName() + " creating personal role....");
    return personalRoleService.createPersonalRole(personalRoleDto);
  }

  @Override
  public PersonalRoleDto updatePersonalRole(
      @PathVariable Integer id,
      @RequestBody @Validated(OnUpdate.class) PersonalRoleDto personalRoleDto) {
    log.info(this.getClass().getSimpleName() + " updating personal role....");
    return personalRoleService.updatePersonalRole(id, personalRoleDto);
  }

  @Override
  public HttpStatus deletePersonalRole(@PathVariable Integer id) {
    log.info(this.getClass().getSimpleName() + " deleting personal role....");
    return personalRoleService.deletePersonalRole(id) ? HttpStatus.OK : HttpStatus.NO_CONTENT;
  }
}
