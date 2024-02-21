package com.example.SmartHouse.Service;

import com.example.SmartHouse.Entity.UserAccountEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserAccountService {
    UserAccountEntity save(UserAccountEntity userAccount);
    List<UserAccountEntity> getAllUserAccount();
    UserAccountEntity getUserAccount(String username, String password);
    UserAccountEntity findUserAccountEntityByUsername(String username);
//    UserAccountEntity findUserAccountByUsernameAndPassword(String username, String password);

    UserAccountEntity findUserAccountEntityByUsernameWithoutHouse(String username);
    UserAccountEntity registerUserAccount(UserAccountEntity userAccountEntity);
    UserAccountEntity updateUserAccount(UserAccountEntity userAccountEntity);
    void deleteUserAccountByID(Integer id);
    void deleteUserByUsername(String username);

    void setTemperature(Integer userID, Float value) ;

    void setHumidity(Integer userID, Float value) ;
}
