package com.repairsystem.dao;

import com.repairsystem.entity.Building;
import com.repairsystem.utils.MyMapper;

public interface BuildingMapper extends MyMapper<Building> {

    Integer getBuildingCount();
}