package com.example.SmartHouse.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "FLOORS")
public class FloorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FLOOR_ID")
    private Integer floorID;

    @Column(name = "FLOOR_NAME")
    private String floorName;

    @Column(name = "HOUSE_ID")
    private Integer houseID;

    @Column(name = "FLOOR_ACTIVE")
    private Integer floorActive;

    @Transient
    List<RoomEntity> rooms;
}
