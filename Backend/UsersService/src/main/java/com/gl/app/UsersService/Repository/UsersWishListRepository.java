package com.gl.app.UsersService.Repository;

import com.gl.app.UsersService.Entity.UsersWishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersWishListRepository extends JpaRepository<UsersWishList,String> {
    @Query("Select wl from UsersWishList wl where wl.users.userID= ?1 and wl.id = ?2")
    UsersWishList findByUserIdAndWishListID(String userID, String wishListID);
    @Query("Select wl from UsersWishList wl where wl.users.userID= ?1")
    List<UsersWishList> findByUserID(String userID);
}
