package com.example.SmartHouse.Service;

import com.example.SmartHouse.Entity.UserAccountEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserAccountService {
    UserAccountEntity save(UserAccountEntity userAccount);

    List<UserAccountEntity> getAllUserAccountList();

    Optional<UserAccountEntity> findUserAccountEntityByUsername(String username);

    UserAccountEntity createUserAccount(UserAccountEntity userAccountEntity);
    UserAccountEntity updateUserAccount(UserAccountEntity userAccountEntity);
    void deleteUserAccountByID(Integer id);

    void deleteUserByUsername(String username);

    Optional<UserAccountEntity> authUser(UserAccountEntity userAccountEntity);
}
