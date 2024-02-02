package com.example.SmartHouse.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ESP32GetDeviceDTO {
    private String PORT;
    private Float value;
    private Integer isRunning;
}
