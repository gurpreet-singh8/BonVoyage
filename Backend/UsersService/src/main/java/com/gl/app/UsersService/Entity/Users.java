package com.gl.app.UsersService.Entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Users")
public class Users {
    @Id
    private String userID;
    @Column(unique = true,nullable = false)
    private String  userName;
    @Column(nullable = false, unique = true)
    @Email
    @NotNull
    private String userEmail;
    @Column(nullable = false, unique = true)
    @NotNull
    private Long  userPhone;
    @Column(nullable = false)
    @NotNull
    private String userPassword;
    @Column(nullable = false)
    @NotNull
    private String userAddress;
    @Column(nullable = false)
    @NotNull
    private  String userRole;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<UsersWishList> usersWishLists;

}
