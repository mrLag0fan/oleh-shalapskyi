package com.example.cruise_company_spring.controller;

import com.example.cruise_company_spring.controller.dto.UserRoleDto;
import com.example.cruise_company_spring.service.UserRoleService;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
public class UserRoleController {

    private final UserRoleService userRoleService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/userRole")
    public List<UserRoleDto> getAllUserRoles() {
        log.info(this.getClass().getSimpleName()
            + " getting all user roles....");
        return userRoleService.getAllUserRoles();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/userRole/{id}")
    public UserRoleDto getUserRole(@PathVariable Integer id) {
        log.info(this.getClass().getSimpleName()
            + " getting user role by id....");
        return userRoleService.getUserRole(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/userRole")
    public UserRoleDto createUserRole(@RequestBody UserRoleDto userRoleDto) {
        log.info(this.getClass().getSimpleName()
            + " creating user role....");
        return userRoleService.createUserRole(userRoleDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/userRole/{id}")
    public UserRoleDto updateUserRole(@PathVariable Integer id,
                                      @RequestBody UserRoleDto userRoleDto) {
        log.info(this.getClass().getSimpleName() + " updating user role....");
        return userRoleService.updateUserRole(id, userRoleDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/userRole/{id}")
    public ResponseEntity<Void> deleteUserRole(@PathVariable Integer id) {
        log.info(this.getClass().getSimpleName() + " deleting user role....");
        userRoleService.deleteUserRole(id);
        return ResponseEntity.noContent().build();
    }
}
