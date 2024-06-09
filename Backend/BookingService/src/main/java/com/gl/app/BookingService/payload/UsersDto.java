package com.gl.app.BookingService.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {
    private String userID;
    private String userName;
    private String userEmail;
    private Long userPhone;
    private String userPassword;
    private String userAddress;
    private String userRole;
    private List<String> usersWishList;
}
