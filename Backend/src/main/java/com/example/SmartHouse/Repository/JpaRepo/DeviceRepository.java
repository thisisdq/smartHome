package com.example.SmartHouse.Repository.JpaRepo;

import com.example.SmartHouse.Entity.DeviceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceEntity, Integer> {

    @Query("Select d from DeviceEntity d Where d.roomID = :id")
    List<DeviceEntity> findAllByRoomId(@Param("id") Integer id);

//    @Query("Select d from DeviceEntity d Where d.userAccountID = :id")
//    List<DeviceEntity> findByUserAccountID(@Param("id") Integer id);

    @Query("Select d from DeviceEntity d Where d.userAccountID = :id")
    List<DeviceEntity> findDeviceByUserAccountID(@Param("id") Integer id);

    @Query("Select d from DeviceEntity d Where d.userAccountID = :id and d.devicePort is not null")
    List<DeviceEntity> findDeviceByUserAccountIDwhenPortNotNull(@Param("id") Integer id);



    @Modifying
    @Transactional
    @Query("UPDATE DeviceEntity d SET d.isRunning = 0 WHERE d.userAccountID = :id AND d.deviceTypeID = 7")
    void turnOffTV(@Param("id") Integer id);

//    @Modifying
//    @Transactional
//    @Query("UPDATE DeviceEntity d SET d.deviceValue = :humidity WHERE d.deviceTypeID =6 and d.userAccountID = :id")
//    void setHumidity(@Param("id") Integer id, @Param("humidity") Float humidity);

    @Modifying
    @Transactional
    @Query("UPDATE DeviceEntity d SET d.isRunning = :value WHERE d.id in " +
            "(" +
            "SELECT d.id FROM UserAccountEntity u " +
            "LEFT JOIN HouseEntity h ON h.userID = u.userAccountID " +
            "LEFT JOIN FloorEntity f ON f.houseID = h.houseID " +
            "LEFT JOIN RoomEntity r ON r.floorID = f.floorID " +
            "LEFT JOIN DeviceEntity d ON d.roomID = r.roomID " +
            "WHERE r.roomID = :UHFR_ID AND u.userAccountID = :userID" +
            ")")
    void turnOnOffAllDeviceByRoomID(@Param("userID") Integer userID, @Param("UHFR_ID") Integer UHFR_ID, @Param("value") Integer value);

    @Modifying
    @Transactional
    @Query("UPDATE DeviceEntity d SET d.isRunning = :value Where d.id in " +
            "(" +
            "SELECT d.id FROM UserAccountEntity u " +
            "LEFT JOIN HouseEntity h ON h.userID = u.userAccountID " +
            "LEFT JOIN FloorEntity f ON f.houseID = h.houseID " +
            "LEFT JOIN RoomEntity r ON r.floorID = f.floorID " +
            "LEFT JOIN DeviceEntity d ON d.roomID = r.roomID " +
            "WHERE f.floorID = :UHFR_ID AND u.userAccountID = :userID" +
            ")")
    void turnOnOffAllDeviceByFloorID(@Param("userID") Integer userID, @Param("UHFR_ID") Integer UHFR_ID, @Param("value") Integer value);

    @Modifying
    @Transactional
    @Query("UPDATE DeviceEntity d SET d.isRunning = :value Where d.id in " +
            "(" +
            "SELECT d.id FROM UserAccountEntity u " +
            "LEFT JOIN HouseEntity h ON h.userID = u.userAccountID " +
            "LEFT JOIN FloorEntity f ON f.houseID = h.houseID " +
            "LEFT JOIN RoomEntity r ON r.floorID = f.floorID " +
            "LEFT JOIN DeviceEntity d ON d.roomID = r.roomID " +
            "WHERE h.houseID = :UHFR_ID AND u.userAccountID = :userID" +
            ")")
    void turnOnOffAllDeviceByHouseID(@Param("userID") Integer userID, @Param("UHFR_ID") Integer UHFR_ID, @Param("value") Integer value);
}
