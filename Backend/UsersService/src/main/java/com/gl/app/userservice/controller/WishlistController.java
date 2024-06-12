package com.gl.app.userservice.controller;

import com.gl.app.userservice.payload.ResponseDto;
import com.gl.app.userservice.payload.SuccessDto;
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
    @CrossOrigin("*")
    @PostMapping
    public ResponseEntity<WishlistDto> createWishlist(@PathVariable String userId){
        return new ResponseEntity<>(wishlistService.createWishlist(userId,new WishlistDto()), HttpStatus.CREATED);
    }
    @CrossOrigin("*")
    @PostMapping("/{wishlistId}/{packageId}")
    ResponseEntity<SuccessDto> addPackageToWishlist(@PathVariable(name = "userId") String userId, @PathVariable(name = "wishlistId") String wishlistId, @PathVariable(name = "packageId") String packageId){
        return ResponseEntity.ok(new SuccessDto(wishlistService.addPackageToWishlist(userId,wishlistId,packageId)));
    }
    @CrossOrigin("*")
    @DeleteMapping("/{wishlistId}/{packageId}")
    ResponseEntity<SuccessDto> deletePackageWishlist(@PathVariable(name = "userId") String userId, @PathVariable(name = "wishlistId") String wishlistId, @PathVariable(name = "packageId") String packageId){
        return ResponseEntity.ok(new SuccessDto(wishlistService.deletePackageWishlist(userId,wishlistId,packageId)));
    }

    @CrossOrigin("*")
    @GetMapping("/{wishlistId}")
    public ResponseEntity<ResponseDto> getWishlist(@PathVariable String userId,@PathVariable String wishlistId){
        return ResponseEntity.ok(wishlistService.getWishlist(userId,wishlistId));
    }


}
