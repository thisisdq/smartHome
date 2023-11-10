package com.example.SmartHouse.Controller;

import com.example.SmartHouse.Entity.UserAccountEntity;
import com.example.SmartHouse.Repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@CrossOrigin("*")
@Controller
public class UserAccountController {
    @Autowired
    private UserAccountRepository userAccountRepository;
    @GetMapping("")
    public ResponseEntity<String> test(){
        return new ResponseEntity<>("TEST", HttpStatus.OK);
    }

    @GetMapping("/userAccount")
    public ResponseEntity<List<UserAccountEntity>> getUserA(){
        List<UserAccountEntity> usa = userAccountRepository.findAll();
        if(usa.isEmpty()){return new ResponseEntity<>(HttpStatus.NO_CONTENT);}
        else {
            return new ResponseEntity<>(usa,HttpStatus.OK);
        }
    }
}
