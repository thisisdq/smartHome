package com.example.SmartHouse.ServiceImpl;

import com.example.SmartHouse.Entity.UserAccountEntity;
import com.example.SmartHouse.Repository.JpaRepo.UserAccountRepository;
import com.example.SmartHouse.Service.HouseService;
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

    @Autowired
    private HouseService houseService;

    @Override
    @Transactional
    public UserAccountEntity save(UserAccountEntity userAccount) {
        return userAccountRepository.save(userAccount);
    }

    @Override
    public List<UserAccountEntity> getAllUserAccount(){
        List<UserAccountEntity> user = userAccountRepository.findAll();
        for (UserAccountEntity u : user){
            updateHouseForUserAccount(u);
        }
        return user;
    }

    @Override
    @Transactional
    public UserAccountEntity registerUserAccount(UserAccountEntity userAccountEntity){
        return userAccountRepository.save(userAccountEntity);
    }

    @Override
    public UserAccountEntity findUserAccountEntityByUsername(String username){
        return userAccountRepository.findUserAccountEntityByUsername(username).orElse(null);
    }

//    @Override
//    public UserAccountEntity findUserAccountByUsernameAndPassword(String username, String password){
//        UserAccountEntity _user = userAccountRepository.findUserAccountEntityByUsernameAndPassword(username,password).orElse(null);
//        return updateHouseForUserAccount(_user);
//    }

    @Override
    @Transactional
    public UserAccountEntity updateUserAccount(UserAccountEntity userAccountEntity){
        UserAccountEntity _user = userAccountRepository
                .findUserAccountEntityByUsername(userAccountEntity.getUsername()).orElse(null);
        if ( _user != null){
            _user.setPassword(userAccountEntity.getPassword());
            userAccountRepository.updatePasswordWhenUsername(_user.getUsername(),_user.getPassword());
            return _user;
        }
        else return null;
    }

    @Override
    @Transactional
    public void deleteUserAccountByID(Integer id){
        userAccountRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteUserByUsername(String username) {
        userAccountRepository.deleteUserByUsername(username);

    }

    @Override
    public UserAccountEntity getUserAccount(String username, String password) {
        UserAccountEntity _userAccountEntity = userAccountRepository.findUserAccountEntityByUsernameAndPassword(username,password).orElse(null);
        if(_userAccountEntity != null ){
            _userAccountEntity.setPassword(null);
        }
        return updateHouseForUserAccount(_userAccountEntity);
    }

    private UserAccountEntity updateHouseForUserAccount(UserAccountEntity userAccount){
        if (userAccount != null ){
            userAccount.setHouses(houseService.findAllByUserId(userAccount.getUserAccountID()));
        }
        return userAccount;
    }
}

