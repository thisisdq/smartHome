package com.example.SmartHouse.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "ROOMS")
public class RoomEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "ROOM_ID")
    private Integer roomID;

    @Column(name = "ROOM_NAME")
    private String roomName;

    @Column(name = "FLOOR_ID")
    private Integer floorID;

    @Transient
    List<DeviceEntity> devices;
}
