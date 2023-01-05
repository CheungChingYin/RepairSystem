package com.repairsystem.service;

import com.repairsystem.entity.Building;

import java.util.List;

/**
 * @author CheungChingYin
 * @date 2018/10/30
 * @time 21:02
 */
public interface BuildingService {

    /**
     * 获取所有教学楼信息
     *
     * @return 教学楼信息
     */
    List<Building> searchAllBuilding();

    /**
     * 通过教学楼编号获取教学楼信息
     *
     * @param id 教学楼id
     * @return 教学楼信息
     */
    Building searchBuildingById(Integer id);

    /**
     * 通过教学楼名字获取教学楼信息
     *
     * @param name 教学楼名称
     * @return 教学楼信息
     */
    List<Building> searchBuildingByName(String name);

    /**
     * 获得实训楼总数
     *
     * @return 教学楼总数
     */
    Integer getBuildingCount();

    /**
     * 保存教学楼信息
     *
     * @param building 教学楼信息
     */
    void savBuilding(Building building);

    /**
     * 更新教学楼信息
     *
     * @param building 教学楼信息
     */
    void updateBuilding(Building building);

    /**
     * 删除教学楼信息
     *
     * @param id 教学楼id
     */
    void deleteBuilding(Integer id);


}
