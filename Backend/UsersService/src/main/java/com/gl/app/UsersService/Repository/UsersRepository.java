package com.gl.app.UsersService.Repository;

import com.gl.app.UsersService.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,String> {
    Optional<Users> findByUserName(String userName);
    Optional<Users> findByUserEmailAndUserPassword(String userEmail, String userPassword);

    @Query("SELECT u FROM Users u, UsersWishList wl where wl.users.userID=u.userID and u.userID = ?1 and wl.wishlistID = ?2")
    Optional<Users> findByUserIdAndWishListID(String userID, String wishListID);
}
