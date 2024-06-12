package com.gl.app.userservice.controller;

import com.gl.app.userservice.payload.ResponseDto;
import com.gl.app.userservice.payload.WishlistDto;
import com.gl.app.userservice.service.WishlistService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users/{userId}")
@AllArgsConstructor
public class WishlistController {

    private final WishlistService wishlistService;
    @PostMapping
    public ResponseEntity<WishlistDto> createWishlist(@PathVariable String userId){
        return new ResponseEntity<>(wishlistService.createWishlist(userId,new WishlistDto()), HttpStatus.CREATED);
    }

    @PostMapping("/{wishlistId}/{packageId}")
    ResponseEntity<String> addPackageToWishlist(@PathVariable(name = "userId") String userId, @PathVariable(name = "wishlistId") String wishlistId, @PathVariable(name = "packageId") String packageId){
        return ResponseEntity.ok(wishlistService.addPackageToWishlist(userId,wishlistId,packageId));
    }

    @DeleteMapping("/{wishlistId}/{packageId}")
    ResponseEntity<String> deletePackageWishlist(@PathVariable(name = "userId") String userId, @PathVariable(name = "wishlistId") String wishlistId, @PathVariable(name = "packageId") String packageId){
        return ResponseEntity.ok(wishlistService.deletePackageWishlist(userId,wishlistId,packageId));
    }


    @GetMapping("/{wishlistId}")
    public ResponseEntity<ResponseDto> getWishlist(@PathVariable String userId,@PathVariable String wishlistId){
        return ResponseEntity.ok(wishlistService.getWishlist(userId,wishlistId));
    }


}
