package com.example.SmartHouse.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurnOnOffAllDTO {

    Integer userID;
    Integer id;
    Integer value;
}
