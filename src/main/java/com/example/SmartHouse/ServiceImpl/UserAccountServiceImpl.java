package com.example.SmartHouse.ServiceImpl;

import com.example.SmartHouse.Entity.UserAccountEntity;
import com.example.SmartHouse.Repository.UserAccountRepository;
import com.example.SmartHouse.Service.UserAccountService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    private UserAccountRepository userAccountRepository;

    public List<UserAccountEntity> getAllUserAccountList(){
        return userAccountRepository.findAll();
    }

    public Optional<UserAccountEntity> findUserAccountEntityByUsername(String username){
        return userAccountRepository.findUserAccountEntityByUsername(username);
    }

    @Transactional
    public UserAccountEntity createUserAccount(UserAccountEntity userAccountEntity){
        return userAccountRepository.save(userAccountEntity);
    }

    @Transactional
    public Optional<UserAccountEntity> updateUserAccount(UserAccountEntity userAccountEntity){
        Optional<UserAccountEntity> _user = userAccountRepository
                .findUserAccountEntityByUsername(userAccountEntity.getUsername());
        if ( _user.isPresent()){
            _user.get().setPassword(userAccountEntity.getPassword());
            userAccountRepository.updatePasswordWhenUsername(_user.get().getUsername(),_user.get().getPassword());
            return _user;
        }
        else return Optional.empty();
    }

    @Transactional
    public void deleteUserAccountByID(Integer id){
        userAccountRepository.deleteById(id);
    }

    @Transactional
    public void deleteUserByUsername(String username) {
        userAccountRepository.deleteUserByUsername(username);

    }
}

