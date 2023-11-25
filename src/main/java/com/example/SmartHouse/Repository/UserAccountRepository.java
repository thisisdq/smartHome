package com.example.SmartHouse.Repository;

import com.example.SmartHouse.Entity.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccountEntity,Integer> {

    Optional<UserAccountEntity> findUserAccountEntityByUsername(String username);

    @Modifying
    @Query("update UserAccountEntity u set u.password = :password where u.username = :username ")
    void updatePasswordWhenUsername(@Param("username") String username,@Param("password") String password);

    @Modifying
    @Query("delete UserAccountEntity u where u.username = :username")
    void deleteUserByUsername(@Param("username") String username);

    @Query("Select u from UserAccountEntity u  where u.username = :username and u.password = :password")
    Optional<UserAccountEntity> authUser(@Param("username") String username,@Param("password") String password);
}
