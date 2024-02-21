package com.example.SmartHouse.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class TemperatureAndHumityDTO {
    private Float temperature;
    private Float humidity;
}
