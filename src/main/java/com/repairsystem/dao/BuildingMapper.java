package com.repairsystem.dao;

import com.repairsystem.entity.Building;
import com.repairsystem.utils.MyMapper;

public interface BuildingMapper extends MyMapper<Building> {

    /**
     * 获得教学楼数量
     *
     * @return 教学楼数量
     */
    Integer getBuildingCount();
}