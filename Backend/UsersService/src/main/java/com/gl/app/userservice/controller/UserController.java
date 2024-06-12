package com.gl.app.userservice.controller;

import com.gl.app.userservice.payload.UserDto;
import com.gl.app.userservice.payload.UserLoginDto;
import com.gl.app.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @CrossOrigin("*")
    @PostMapping("/register")
    ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto userDto){
        return new ResponseEntity<>(userService.registerUser(userDto), HttpStatus.CREATED);
    }

    @CrossOrigin("*")
    @PostMapping("/login")
    ResponseEntity<UserDto> loginUser(@Valid @RequestBody UserLoginDto userLoginDto){
        return ResponseEntity.ok(userService.loginUser(userLoginDto.getEmail(),userLoginDto.getPassword()));
    }

    @CrossOrigin("*")
    @GetMapping("/{name}")
    ResponseEntity<UserDto> getUserByName(@PathVariable(name = "name") String name){
        return ResponseEntity.ok(userService.getUserByName(name));
    }
}
