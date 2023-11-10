package com.example.SmartHouse.Repository;

import com.example.SmartHouse.Entity.UserAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccountEntity,Integer> {
}
