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
    @Query("UPDATE DeviceEntity d SET d.deviceValue = :temperature WHERE d.deviceTypeID =5 and d.userAccountID = :id")
    void setTemperature(@Param("id") Integer id, @Param("temperature") Float temperature);

//    @Query("Select d from Device d where d.userAccountID = :userID and d.deviceTypeID = 5")
//    DeviceEntity getTemperatureDevice(@Param("userID") Integer userID);

    @Modifying
    @Transactional
    @Query("UPDATE DeviceEntity d SET d.deviceValue = :humidity WHERE d.deviceTypeID =6 and d.userAccountID = :id")
    void setHumidity(@Param("id") Integer id, @Param("humidity") Float humidity);
}
