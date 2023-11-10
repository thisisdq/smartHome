package com.example.SmartHouse.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_account")
public class UserAccountEntity {
    @Id
    @Column(name = "USER_ACCOUNT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userAccountID;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;
}