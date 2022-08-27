package com.example.cruise_company.controller;

import com.example.cruise_company.controller.dto.PersonalRoleDto;
import com.example.cruise_company.service.PersonalRoleService;
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
@RequestMapping("/personalRole")
public class PersonalRoleController {
  private final PersonalRoleService personalRoleService;

  @ResponseStatus(HttpStatus.OK)
  @GetMapping
  public List<PersonalRoleDto> getAllPersonalRoles() {
    log.info(this.getClass().getSimpleName() + " getting all personal role....");
    return personalRoleService.getAllPersonalRoles();
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/{id}")
  public PersonalRoleDto getPersonalRole(@PathVariable Integer id) {
    log.info(this.getClass().getSimpleName() + " getting personal role by id....");
    return personalRoleService.getPersonalRoleById(id);
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public PersonalRoleDto createPersonalRole(@RequestBody PersonalRoleDto personalRoleDto) {
    log.info(this.getClass().getSimpleName() + " creating personal role....");
    return personalRoleService.createPersonalRole(personalRoleDto);
  }

  @ResponseStatus(HttpStatus.OK)
  @PutMapping(value = "/{id}")
  public PersonalRoleDto updatePersonalRole(
      @PathVariable Integer id, @RequestBody PersonalRoleDto personalRoleDto) {
    log.info(this.getClass().getSimpleName() + " updating personal role....");
    return personalRoleService.updatePersonalRole(id, personalRoleDto);
  }

  @ResponseStatus(HttpStatus.OK)
  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> deletePersonalRole(@PathVariable Integer id) {
    log.info(this.getClass().getSimpleName() + " deleting personal role....");
    personalRoleService.deletePersonalRole(id);
    return ResponseEntity.noContent().build();
  }
}
