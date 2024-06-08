package com.gl.app.UsersService.Controller;

import com.gl.app.UsersService.Entity.UsersWishList;
import com.gl.app.UsersService.Payload.UsersDto;
import com.gl.app.UsersService.service.UsersWishListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wishList")
public class UsersWishListController {

    private final UsersWishListService usersWishListService;

    public UsersWishListController(UsersWishListService usersWishListService) {
        this.usersWishListService = usersWishListService;
    }

    @GetMapping ("/{userID}/{wishlistID}")
    public ResponseEntity<UsersDto> addWishList(@PathVariable String userID, @PathVariable String wishlistID) {

        return ResponseEntity.ok(usersWishListService.getWishList(userID, wishlistID));
    }

    @DeleteMapping("/{userID}/{wishlistID}")
    public ResponseEntity<List<UsersWishList>> deleteWishList(@PathVariable String userID, @PathVariable String wishlistID) {
        usersWishListService.deleteWishList(userID, wishlistID);
        List<UsersWishList> updatedWishlists = usersWishListService.getWishListByUserID(userID);
        return ResponseEntity.ok(updatedWishlists);
    }

    @GetMapping("/{userID}")
    public ResponseEntity<List<UsersWishList>> getWishListByUserID(@PathVariable String userID) {
        List<UsersWishList> wishlists = usersWishListService.getWishListByUserID(userID);
        return ResponseEntity.ok(wishlists);
    }

}
