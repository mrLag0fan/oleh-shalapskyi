package com.example.cruise_company_spring.controller;


import com.example.cruise_company_spring.controller.dto.UserDto;
import com.example.cruise_company_spring.service.UserService;
import com.example.cruise_company_spring.service.model.User;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user")
    public List<UserDto> getAllUsers(){
        log.info(this.getClass().getSimpleName() +" getting all users....");
        return userService.getAllUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user/{email}")
    public UserDto getUser(@PathVariable String email){
        log.info(this.getClass().getSimpleName() +" getting user by id....");
        return userService.getUser(email);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/user")
    public UserDto createUser(@RequestBody UserDto userDto){
        log.info(this.getClass().getSimpleName() +" creating user....");
        return userService.createUser(userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/user/{email}")
    public UserDto updateUser(@PathVariable String email, @RequestBody UserDto userDto){
        log.info(this.getClass().getSimpleName() +" updating user....");
        return userService.updateUser(email, userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/user/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email){
        log.info(this.getClass().getSimpleName() +" deleting user....");
        userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }

}
