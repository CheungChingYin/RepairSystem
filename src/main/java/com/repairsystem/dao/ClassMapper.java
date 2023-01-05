package com.repairsystem.dao;

import com.repairsystem.entity.Class;
import com.repairsystem.entity.vo.ClassVO;
import com.repairsystem.utils.MyMapper;

import java.util.List;

public interface ClassMapper extends MyMapper<Class> {

    /**
     * 获得全部教室信息
     *
     * @return
     */
    List<Class> getAllClass();

    /**
     * 根据教室id获得教室信息
     *
     * @param id 教室Id
     * @return 教室信息
     */
    Class getClassById(Integer id);

    /**
     * 根据教室名称获得教室信息
     *
     * @param name 教室名称
     * @return 教室信息
     */
    List<Class> getClassByName(String name);

    /**
     * 通过教学楼Id获得该教学楼的教室信息
     *
     * @param buildingId 教学楼id
     * @return 教室信息
     */
    List<Class> getClassByBuildingId(String buildingId);

    /**
     * 获得教室数量
     *
     * @return 教室数量
     */
    Integer getClassCount();
}