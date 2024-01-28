package com.example.SmartHouse.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DEVICES_TYPE")
public class DeviceTypeEntity {

    @Id
    @Column(name = "DEVICE_TYPE_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer DeviceTypeID;

    @Column(name = "DEVICE_TYPE")
    private String DeviceType;
}
