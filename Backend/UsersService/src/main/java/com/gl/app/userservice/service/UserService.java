package com.gl.app.userservice.service;


import com.gl.app.userservice.payload.UserDto;

public interface UserService {
    public UserDto registerUser(UserDto userDto);
    public UserDto getUserByName(String name);
    public UserDto loginUser(String email, String password);
}
