package com.gl.app.UsersService.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private Users users;
}
