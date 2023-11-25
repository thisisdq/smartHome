package com.example.SmartHouse.Controller;

import com.example.SmartHouse.Entity.UserAccountEntity;
import com.example.SmartHouse.Service.UserAccountService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/updateUserAccount")
    public ResponseEntity<UserAccountEntity> updateUserAccount(@NotNull @RequestBody UserAccountEntity userAccountEntity){
        try {
            Optional<UserAccountEntity> user = userAccountService.updateUserAccount(userAccountEntity);
            return user.map(userAccount -> new ResponseEntity<>(userAccount, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping("/editPassword")
//    public ResponseEntity<UserAccountEntity> changePassword (@RequestBody UserAccountEntity userAccount){
//        try {
//            Optional<UserAccountEntity> user = userAccountRepository.findUserAccountEntityByUsername(userAccount.getUsername());
//            if(user.isPresent()){
//                user.get().setPassword(userAccount.getPassword());
//                return new ResponseEntity<>(userAccountRepository.save(user.get()), HttpStatus.OK);
//            }
//            else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }catch (Error e) {
//            System.out.println(e.getMessage());
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PostMapping("/deleteUser")
    public void deleteUserByID(@RequestBody @NotNull UserAccountEntity userAccountEntity){
        Assert.notNull(userAccountEntity.getUserAccountID(),"UserAccountID must be not null!");
        userAccountService.deleteUserAccountByID(userAccountEntity.getUserAccountID());
    }

    @PostMapping("/deleteUserByUsername")
    public void deleteUserByUsername(@RequestBody @NotNull UserAccountEntity userAccountEntity){
        Assert.notNull(userAccountEntity.getUsername(),"Username must be not null!");
        userAccountService.deleteUserByUsername(userAccountEntity.getUsername());
    }

    @PostMapping("authUser")
    public ResponseEntity<UserAccountEntity> authUser(@RequestBody UserAccountEntity userAccount){
        System.out.println(userAccount);
        Assert.notNull(userAccount.getUsername(),"Username must not be null");
        Assert.notNull(userAccount.getPassword(),"Password must not be null");
        Optional<UserAccountEntity> _user =userAccountService.authUser(userAccount);

        if (_user.isPresent()){
            return new ResponseEntity<>(_user.get(),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
