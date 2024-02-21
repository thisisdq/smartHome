package com.example.SmartHouse.DTO;
import com.example.SmartHouse.Entity.FloorEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterFloorDTO {
    private Integer houseID;
    private FloorEntity floorEntity;
}