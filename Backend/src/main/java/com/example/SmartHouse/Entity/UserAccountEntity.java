package com.example.SmartHouse.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

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

    @NotNull
    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "FULLNAME")
    private String fullname;

    @Column(name = "Temperature")
    private Float temperature;

    @Column(name = "Humidity")
    private Float humidity;

    @Transient
    private List<HouseEntity> houses;

}