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

    @Column(name = "DEVICE_NAME")
    private String deviceName;

    @Column(name = "DEVICE_STATUS")
    private String deviceStatus;

    @Column(name = "DEVICE_TYPE_ID")
    private Integer deviceTypeID;

    @Column(name = "DEVICE_VALUE")
    private Integer deviceValue;

    @Column(name = "is_Running")
    private Integer isRunning;

    @Column(name = "ROOM_ID")
    private Integer roomID;

    @Column(name = "DEVICE_PORT")
    private String devicePort;

    @Transient
    private String DeviceType;

}

