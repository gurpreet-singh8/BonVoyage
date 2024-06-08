package com.gl.app.UsersService.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "UsersWishList")
public class UsersWishList {
    @Id
    private String wishlistID;

    @ManyToOne
    @JoinColumn(name = "userID", nullable = false)
    @NotNull
    private Users users;
}
