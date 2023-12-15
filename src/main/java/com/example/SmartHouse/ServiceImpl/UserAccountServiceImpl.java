package com.example.SmartHouse.ServiceImpl;

import com.example.SmartHouse.Entity.HouseEntity;
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
    public List<UserAccountEntity> getAllUserAccountList(){
        List<UserAccountEntity> user = userAccountRepository.findAll();
        for (UserAccountEntity u : user){
            List<HouseEntity> _house = houseService.findAllByUserId(u.getUserAccountID());
            u.setHouses(_house);
        }
        return user;
    }

    @Override
    public Optional<UserAccountEntity> findUserAccountEntityByUsername(String username){
        return userAccountRepository.findUserAccountEntityByUsername(username);
    }

    @Override
    @Transactional
    public UserAccountEntity createUserAccount(UserAccountEntity userAccountEntity){
        return userAccountRepository.save(userAccountEntity);
    }

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
    public Optional<UserAccountEntity> authUser(UserAccountEntity userAccountEntity) {
        return userAccountRepository.authUser(userAccountEntity.getUsername(),userAccountEntity.getPassword());

    }
}

