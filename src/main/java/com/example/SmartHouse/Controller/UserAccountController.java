package com.example.SmartHouse.Controller;

import com.example.SmartHouse.Entity.UserAccountEntity;
import com.example.SmartHouse.Repository.UserAccountRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@Controller
public class UserAccountController {
    @Autowired
    private UserAccountRepository userAccountRepository;
    @GetMapping("")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("TEST", HttpStatus.OK);
    }

    @PostMapping("/userAccount")
    public ResponseEntity<List<UserAccountEntity>> getAllUserAccount(){
        try {
            List<UserAccountEntity> usa = userAccountRepository.findAll();
            if(usa.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            else {
                return new ResponseEntity<>(usa,HttpStatus.OK);
            }
        } catch (Error e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/createUserAccount")
    public ResponseEntity<UserAccountEntity> createNewUser(@NotNull @RequestBody UserAccountEntity userAccount){
        try {
            if(userAccountRepository
                    .findUserAccountEntityByUsername(userAccount.getUsername())
                    .isPresent()){
                return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
            }
            else {
                UserAccountEntity user = userAccountRepository.save(userAccount);
                return new ResponseEntity<>(user,HttpStatus.CREATED);
            }
        }catch (Error e){
            System.out.println("error");
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/editUserAccount")
    public ResponseEntity<UserAccountEntity> editUserAccount(@NotNull @RequestBody UserAccountEntity userAccountEntity){
        try {
            Optional<UserAccountEntity> user = userAccountRepository.findUserAccountEntityByUsername(userAccountEntity.getUsername());
            if (user.isEmpty()){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            else {
                user.get().setPassword(userAccountEntity.getPassword());
                user.get().setUsername(userAccountEntity.getUsername());
                return new ResponseEntity<>(userAccountRepository.save(user.get()),HttpStatus.OK);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/editPassword")
    public ResponseEntity<UserAccountEntity> changePassword (@RequestBody UserAccountEntity userAccount){
        try {
            Optional<UserAccountEntity> user = userAccountRepository.findUserAccountEntityByUsername(userAccount.getUsername());
            if(user.isPresent()){
                user.get().setPassword(userAccount.getPassword());
                return new ResponseEntity<>(userAccountRepository.save(user.get()), HttpStatus.OK);
            }
            else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Error e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/deleteUser")
    public ResponseEntity<String> deleteUser(@RequestBody @NotNull String username){
        try {
            Optional<UserAccountEntity> user = userAccountRepository.findUserAccountEntityByUsername(username);
            if(user.isPresent()){
                userAccountRepository.deleteById(user.get().getUserAccountID());
                return new ResponseEntity<>("Deleted",HttpStatus.OK);
            }
            else return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Error e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
