package com.example.SmartHouse.DTO;

import com.example.SmartHouse.Entity.HouseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAccountDataDTO {
    private Integer userAccountID;
    private String username;
    private String fullname;
    private List<HouseEntity> houses;
}
