package com.gl.app.UsersService.Controller;

import com.gl.app.UsersService.Payload.UsersDto;
import com.gl.app.UsersService.service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Users")
public class UsersController {
    private final UsersService usersService;
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }
    @PostMapping("/register")
    public ResponseEntity<UsersDto> registerUser(@RequestBody UsersDto usersDto){
        UsersDto createdUser = usersService.registerUser(usersDto);
        return ResponseEntity.ok(createdUser);
    }
    @PostMapping("/login")
    public ResponseEntity<UsersDto> loginUser(@RequestBody UsersDto usersDto) {
        UsersDto loggedInUser = usersService.loginUser(usersDto.getUserEmail(), usersDto.getUserPassword());
        return ResponseEntity.ok(loggedInUser);
    }

    @GetMapping("/{userName}")
    public ResponseEntity<UsersDto> getUserByName(@PathVariable String userName) {
        UsersDto usersDto = usersService.getUserByName(userName);
        return ResponseEntity.ok(usersDto);
    }
    @GetMapping("/id/{userId}")
    public ResponseEntity<UsersDto> getUserById(@PathVariable String userId) {
        UsersDto usersDto = usersService.getUserById(userId);
        return ResponseEntity.ok(usersDto);
    }

}
