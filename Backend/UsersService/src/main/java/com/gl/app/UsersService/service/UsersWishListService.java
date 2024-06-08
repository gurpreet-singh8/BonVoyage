package com.gl.app.UsersService.service;

import com.gl.app.UsersService.Entity.UsersWishList;
import com.gl.app.UsersService.Payload.UsersDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsersWishListService {
    UsersDto getWishList(String userID, String wishlistID);
    void deleteWishList(String userID, String wishlistID);
    List<UsersWishList> getWishListByUserID(String userID);
}
