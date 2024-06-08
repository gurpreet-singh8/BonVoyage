package com.gl.app.UsersService.service.Impl;

import com.gl.app.UsersService.Entity.Users;
import com.gl.app.UsersService.Entity.UsersWishList;
import com.gl.app.UsersService.Payload.UsersDto;
import com.gl.app.UsersService.Repository.UsersRepository;
import com.gl.app.UsersService.Repository.UsersWishListRepository;
import com.gl.app.UsersService.exception.ResourceNotFoundException;
import com.gl.app.UsersService.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;
    private final UsersWishListRepository usersWishListRepository;

    public UsersServiceImpl(UsersRepository usersRepository, UsersWishListRepository usersWishListRepository) {
        this.usersRepository = usersRepository;
        this.usersWishListRepository = usersWishListRepository;
    }
    public Users mapToEntity(UsersDto usersDto){
        Users users = new Users();
        users.setUserID(usersDto.getUserID());
        users.setUserName(usersDto.getUserName());
        users.setUserEmail(usersDto.getUserEmail());
        users.setUserPhone(usersDto.getUserPhone());
        users.setUserPassword(usersDto.getUserPassword());
        users.setUserAddress(usersDto.getUserAddress());
        users.setUserRole(usersDto.getUserRole());
        if (usersDto.getUsersWishList() != null) {
            // Set the user reference
            List<UsersWishList> wishLists = new ArrayList<>();
            for (String s : usersDto.getUsersWishList()) {
                UsersWishList wishList = new UsersWishList();
                wishList.setWishlistID(s);
                wishList.setUsers(users); // Set the user reference
                UsersWishList apply = wishList;
                wishLists.add(apply);
            }
            users.setUsersWishLists(wishLists);
        } else {
            users.setUsersWishLists(new ArrayList<>()); // Initialize with an empty list
        }
        return users;
    }
    public UsersDto mapToDto (Users users){
        UsersDto userDTO = new UsersDto();
        userDTO.setUserID(users.getUserID());
        userDTO.setUserName(users.getUserName());
        userDTO.setUserEmail(users.getUserEmail());
        userDTO.setUserPhone(users.getUserPhone());
        userDTO.setUserAddress(users.getUserAddress());
        userDTO.setUserRole(users.getUserRole());
        if (users.getUsersWishLists() != null) {
            userDTO.setUsersWishList(users.getUsersWishLists().stream()
                    .map(UsersWishList::getWishlistID).toList());
        }else {
            userDTO.setUsersWishList(new ArrayList<>());
        }
        return userDTO;
    }
    @Override
    public UsersDto registerUser(UsersDto usersDto) {
        Users users = mapToEntity(usersDto);
        if (users.getUsersWishLists() != null) {
            for (UsersWishList wishList : users.getUsersWishLists()) {
                wishList.setUsers(users);
            }
        }
        Users savedUser = usersRepository.save(users);
        return mapToDto(savedUser);

    }

    public UsersDto loginUser(String userEmail, String userPassword){
        Users users=usersRepository.findByUserEmailAndUserPassword(userEmail,userPassword)
                .orElseThrow(()->new ResourceNotFoundException("user not found"));
        return mapToDto(users);

        }
    public UsersDto getUserByName(String userName) {
        Users users = usersRepository.findByUserName(userName)
                .orElseThrow(()->new ResourceNotFoundException("user not found"));
        return mapToDto(users);
    }
}


