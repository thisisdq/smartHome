package com.example.SmartHouse.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Houses")
public class HouseEntity {

    @Id
    @Column(name = "HOUSE_ID")
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer houseID;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "USER_ID")
    private Integer userID;

    @Transient
    List<FloorEntity> floors;


}
