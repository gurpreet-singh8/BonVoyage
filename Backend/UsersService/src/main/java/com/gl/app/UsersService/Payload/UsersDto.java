package com.gl.app.UsersService.Payload;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

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
