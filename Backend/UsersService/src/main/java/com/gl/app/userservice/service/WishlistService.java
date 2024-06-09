package com.gl.app.userservice.service;

import com.gl.app.userservice.payload.ResponseDto;
import com.gl.app.userservice.payload.WishlistDto;

public interface WishlistService {
    public WishlistDto createWishlist(String userId,WishlistDto wishlistDto);
    public ResponseDto getWishlist(String userId,String wishlistId);
    public ResponseDto updateWishlist(String userId, WishlistDto wishlistDto);
    public String deletePackageWishlist(String userId, String wishlistId, String packageId);
    public String addPackageToWishlist(String userId,String wishlistId,String packageId);
}
