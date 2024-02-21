package com.example.SmartHouse.DTO;

import com.example.SmartHouse.Entity.DeviceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDeviceDTO {

    private Integer roomID;
    private DeviceEntity device;
}
