package com.example.SmartHouse.Repository.JpaRepo;

import com.example.SmartHouse.Entity.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccountEntity,Integer> {

    Optional<UserAccountEntity> findUserAccountEntityByUsername(String username);


    @Query("SELECT u FROM UserAccountEntity u Where u.userAccountID = :ID")
    Optional<UserAccountEntity> findUserById(@Param("ID") Integer ID);



    @Modifying
    @Query("update UserAccountEntity u set u.password = :password where u.username = :username ")
    void updatePasswordWhenUsername(@Param("username") String username,@Param("password") String password);

    @Modifying
    @Query("delete UserAccountEntity u where u.username = :username")
    void deleteUserByUsername(@Param("username") String username);

    @Query("Select u from UserAccountEntity u  where u.username = :username and u.password = :password")
    Optional<UserAccountEntity> findUserAccountEntityByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
}
