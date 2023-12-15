package com.example.SmartHouse.Entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_account")
public class UserAccountEntity {
    @Id
    @Column(name = "USER_ACCOUNT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userAccountID;

    @Nonnull
    @Column(name = "USERNAME")
    private String username;

    @NonNull
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "FULLNAME")
    private String fullname;

    @Transient
    private List<HouseEntity> houses;

}