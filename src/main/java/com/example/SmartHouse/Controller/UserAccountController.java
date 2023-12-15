package com.example.SmartHouse.Controller;

import com.example.SmartHouse.DTO.ChangePasswordDTO;
import com.example.SmartHouse.Entity.UserAccountEntity;
import com.example.SmartHouse.Service.UserAccountService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @PostMapping("/getAllUserAccount")
    public ResponseEntity<List<UserAccountEntity>> getAllUserAccount(){

//        List<UserAccountEntity> _userAccounts = userAccountService.getAllUserAccountList();

        try {
            List<UserAccountEntity> _userAccountEntities = userAccountService.getAllUserAccountList();
            if(_userAccountEntities.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                return new ResponseEntity<>(_userAccountEntities,HttpStatus.OK);
            }
        } catch (Error e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

//    @PostMapping("getUserAccountById")
//    @ResponseBody public ResponseEntity getUserById(){
//        return ResponseEntity(
//    }

    @PostMapping("/createUserAccount")
    public ResponseEntity<UserAccountEntity> createNewUser(@NotNull @RequestBody UserAccountEntity userAccount){
        try {
            if(userAccountService
                    .findUserAccountEntityByUsername(userAccount.getUsername())
                    .isPresent()){
                return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
            }
            else {
                UserAccountEntity user = userAccountService.createUserAccount(userAccount);
                return new ResponseEntity<>(user,HttpStatus.CREATED);
            }
        }catch (Error e){
            System.out.println("error");
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/changePassword")
    @ResponseBody public ResponseEntity<UserAccountEntity> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO){
        UserAccountEntity user = new UserAccountEntity();
        user.setUsername(changePasswordDTO.getUsername());
        user.setPassword(changePasswordDTO.getOldPassword());
        UserAccountEntity u = userAccountService.authUser(user).orElse(null);
        if(u != null){
            u.setPassword(changePasswordDTO.getNewPassword());
            userAccountService.save(u);
        }
        return ResponseEntity.ok().body(u);
    }

    @PostMapping("/deleteUserByID")
    public void deleteUserByID(@RequestBody @NotNull UserAccountEntity userAccountEntity){
        Assert.notNull(userAccountEntity.getUserAccountID(),"UserAccountID must be not null!");
        userAccountService.deleteUserAccountByID(userAccountEntity.getUserAccountID());
    }

    @PostMapping("/deleteUserByUsername")
    public void deleteUserByUsername(@RequestBody @NotNull UserAccountEntity userAccountEntity){
        Assert.notNull(userAccountEntity.getUsername(),"Username must be not null!");
        userAccountService.deleteUserByUsername(userAccountEntity.getUsername());
    }

    @PostMapping("/authUser")
    @ResponseBody public ResponseEntity<UserAccountEntity> authUser(@RequestBody UserAccountEntity userAccount){
        System.out.println(userAccount);
        Assert.notNull(userAccount.getUsername(),"Username must not be null");
        Assert.notNull(userAccount.getPassword(),"Password must not be null");
        UserAccountEntity user = userAccountService.authUser(userAccount).orElse(null);

        if (user != null){
            return ResponseEntity.ok().body(user);
        }
        else {
            System.out.println("FAILED LOGIN!");
            return ResponseEntity.ok(null);
        }
    }
}
