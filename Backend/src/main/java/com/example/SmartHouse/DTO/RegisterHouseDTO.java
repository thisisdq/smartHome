package com.example.SmartHouse.DTO;

import com.example.SmartHouse.Entity.HouseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterHouseDTO {
    private Integer userID;
    private HouseEntity houseEntity;
}
