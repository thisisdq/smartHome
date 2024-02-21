package com.example.SmartHouse.DTO;

import com.example.SmartHouse.Entity.RoomEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRoomDTO {
    private Integer floorID;
    private RoomEntity roomEntity;
}
