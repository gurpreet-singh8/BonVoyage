package com.gl.app.userservice.payload;

import com.gl.app.userservice.entity.Wishlist;
import com.gl.app.userservice.utils.UserUtils;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDto {
    private String id;

    @NotNull(message="Name cannot be empty")
    private String name;

    @NotNull(message="Email cannot be empty")
    @Email(message= "Enter a valid email")
    private String email;

    @NotNull(message="Password cannot be empty")
    private String password;

    @NotNull(message="Phone cannot be empty")
    private String phone;

    @NotNull(message="Address cannot be empty")
    private String address;

    private String role;
    private List<WishlistDto> wishlist;
}


