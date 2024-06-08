package com.gl.app.UsersService.service.Impl;

import com.gl.app.UsersService.Entity.Users;
import com.gl.app.UsersService.Entity.UsersWishList;
import com.gl.app.UsersService.Payload.UsersDto;
import com.gl.app.UsersService.Repository.UsersRepository;
import com.gl.app.UsersService.Repository.UsersWishListRepository;
import com.gl.app.UsersService.exception.ResourceNotFoundException;
import com.gl.app.UsersService.service.UsersWishListService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersWishListServiceImpl implements UsersWishListService {

    private final UsersWishListRepository usersWishListRepository;
    private final UsersRepository usersRepository;
    public UsersWishListServiceImpl(UsersWishListRepository usersWishListRepository, UsersRepository usersRepository) {
        this.usersWishListRepository = usersWishListRepository;
        this.usersRepository = usersRepository;
    }
    public UsersDto mapToDto (Users users){
        UsersDto userDTO = new UsersDto();
        userDTO.setUserID(users.getUserID());
        userDTO.setUserName(users.getUserName());
        userDTO.setUserEmail(users.getUserEmail());
        userDTO.setUserPhone(users.getUserPhone());
        userDTO.setUserAddress(users.getUserAddress());
        userDTO.setUserRole(users.getUserRole());
        userDTO.setUsersWishList(users.getUsersWishLists().stream()
                .map(UsersWishList::getWishlistID).toList());

        return userDTO;
    }
    public UsersWishList addWishlist(String userID, String wishlistID) {
        Users users = usersRepository.findById(userID)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        var wishList = new UsersWishList();
        wishList.setWishlistID(wishlistID);
        wishList.setUsers(users);
        return usersWishListRepository.save(wishList);
    }
    public UsersDto getWishList(String userID, String wishListID){
        Users users=usersRepository.findByUserIdAndWishListID( userID,wishListID)
                .orElseThrow(()->new ResourceNotFoundException("user not found"));
        return mapToDto(users);
    }
    public void deleteWishList(String userID, String wishListID) {
        UsersWishList wishList= usersWishListRepository.findByUserIdAndWishListID(userID, wishListID);
        usersWishListRepository.delete(wishList);
    }

    public List<UsersWishList> getWishListByUserID(String userID) {
        return usersWishListRepository.findByUserID(userID);
    }
}
