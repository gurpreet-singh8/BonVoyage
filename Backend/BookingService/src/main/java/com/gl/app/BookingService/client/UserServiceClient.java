package com.gl.app.BookingService.client;

import com.gl.app.BookingService.payload.UsersDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "UsersService", url = "http://localhost:8080/api/users")
public interface UserServiceClient {
    @GetMapping("/users/{userId}")
    UsersDto getUserById(@PathVariable("userId") String userId);
}
