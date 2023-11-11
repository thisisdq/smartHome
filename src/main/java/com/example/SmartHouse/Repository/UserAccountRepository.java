package com.example.SmartHouse.Repository;

import com.example.SmartHouse.Entity.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccountEntity,Integer> {
    public Optional<UserAccountEntity> findUserAccountEntityByUsername(String username);
}
