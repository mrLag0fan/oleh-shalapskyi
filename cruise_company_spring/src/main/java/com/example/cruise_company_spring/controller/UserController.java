package com.example.cruise_company_spring.controller;


import com.example.cruise_company_spring.controller.dto.UserDto;
import com.example.cruise_company_spring.service.UserService;
import com.example.cruise_company_spring.service.model.User;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user")
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/user/{email}")
    public UserDto getUser(@PathVariable String email){
        return userService.getUser(email);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/user")
    public UserDto createUser(@RequestBody UserDto userDto){
        return userService.createUser(userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(value = "/user/{email}")
    public UserDto updateUser(@PathVariable String email, @RequestBody UserDto userDto){
        return userService.updateUser(email, userDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping(value = "/user/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email){
        userService.deleteUser(email);
        return ResponseEntity.noContent().build();
    }

}
