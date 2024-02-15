package com.example.SmartHouse.Controller;

import com.example.SmartHouse.DTO.AccountDTO;
import com.example.SmartHouse.DTO.ChangePasswordDTO;
import com.example.SmartHouse.Entity.UserAccountEntity;
import com.example.SmartHouse.Service.UserAccountService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @PostMapping("/userAccount/getAll")
    @ResponseBody
    public ResponseEntity<List<UserAccountEntity>> getAllUserAccount(){
        try {
            List<UserAccountEntity> _userAccountEntities = userAccountService.getAllUserAccount();
            return ResponseEntity.ok().body(_userAccountEntities);
        } catch (Error e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/userAccount/account")
    @ResponseBody
    public ResponseEntity<UserAccountEntity> getUserAccount(@RequestBody @NotNull AccountDTO accountDTO){
        UserAccountEntity user = userAccountService.getUserAccount(accountDTO.getUsername(),accountDTO.getPassword());
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/userAccount/fetchDataAccount")
    @ResponseBody
    public ResponseEntity<UserAccountEntity> fetchUserAccount(@RequestBody @NotNull AccountDTO accountDTO){
        System.out.println(accountDTO.getUsername());
        UserAccountEntity user = userAccountService.findUserAccountEntityByUsername(accountDTO.getUsername());
        if(user != null){
            return ResponseEntity.ok().body(user);
        }
        return null;
    }

    @PostMapping("/userAccount/register")
    public ResponseEntity<UserAccountEntity> registerNewUser(@NotNull @RequestBody UserAccountEntity userAccount){
        UserAccountEntity _user = userAccountService.findUserAccountEntityByUsername(userAccount.getUsername());
        if(_user != null){
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        else {
            UserAccountEntity user = userAccountService.registerUserAccount(userAccount);
            return new ResponseEntity<>(user,HttpStatus.CREATED);
        }
    }

    @PostMapping("/userAccount/changePassword")
    @ResponseBody
    public ResponseEntity<UserAccountEntity> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO){
        UserAccountEntity _user =
                userAccountService
                        .getUserAccount(changePasswordDTO.getUsername(),changePasswordDTO.getOldPassword());
        if(_user != null){
            _user.setPassword(changePasswordDTO.getNewPassword());
            userAccountService.save(_user);
        }
        return ResponseEntity.ok().body(_user);
    }

    @PostMapping("/userAccount/deleteUserByID")
    public void deleteUserByID(@RequestBody @NotNull UserAccountEntity userAccountEntity){
        Assert.notNull(userAccountEntity.getUserAccountID(),"UserAccountID must be not null!");
        userAccountService.deleteUserAccountByID(userAccountEntity.getUserAccountID());
    }

    @PostMapping("/userAccount/deleteUserByUsername")
    public void deleteUserByUsername(@RequestBody @NotNull UserAccountEntity userAccountEntity){
        Assert.notNull(userAccountEntity.getUsername(),"Username must be not null!");
        userAccountService.deleteUserByUsername(userAccountEntity.getUsername());
    }
}
