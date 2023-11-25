package com.example.SmartHouse.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "devices")
@AllArgsConstructor
@NoArgsConstructor
public class DeviceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEVICE_ID")
    private Integer id;
}
