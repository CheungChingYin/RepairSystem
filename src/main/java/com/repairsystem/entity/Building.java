package com.repairsystem.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Building {
    /**
     * 实训楼ID
     */
    @Id
    @Column(name = "building_id")
    private Integer buildingId;

    /**
     * 实训楼名称
     */
    @Column(name = "building_name")
    private String buildingName;

    /**
     * 获取实训楼ID
     *
     * @return building_id - 实训楼ID
     */
    public Integer getBuildingId() {
        return buildingId;
    }

    /**
     * 设置实训楼ID
     *
     * @param buildingId 实训楼ID
     */
    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    /**
     * 获取实训楼名称
     *
     * @return building_name - 实训楼名称
     */
    public String getBuildingName() {
        return buildingName;
    }

    /**
     * 设置实训楼名称
     *
     * @param buildingName 实训楼名称
     */
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }
}