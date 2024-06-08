package com.gl.app.UsersService.service;

import com.gl.app.UsersService.Payload.UsersDto;
import org.springframework.stereotype.Service;

@Service
public interface UsersService {
    UsersDto registerUser(UsersDto usersDto);
    UsersDto loginUser(String userEmail, String userPassword);
    UsersDto getUserByName(String userName);
}
