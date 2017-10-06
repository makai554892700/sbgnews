package com.mayousheng.www.sbgnews.mapper;

import com.mayousheng.www.sbgnews.pojo.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("deviceMapper")
public interface DeviceMapper extends JpaRepository<Device, Integer> {

    public Device getDeviceByAndroidId(String androidId);

}
