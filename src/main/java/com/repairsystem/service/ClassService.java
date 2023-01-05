package com.repairsystem.service;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.repairsystem.entity.Class;
import com.repairsystem.entity.vo.ClassVO;

import java.util.List;

/**
 * @author CheungChingYin
 * @date 2018/10/31
 * @time 12:03
 */
public interface ClassService {

    /**
     * 获取全部机房信息
     *
     * @return 机房信息
     */
    List<Class> searchAllClass();

    /**
     * 通过机房ID获取机房信息
     *
     * @param id 机房Id
     * @return 机房信息
     */
    Class searchClassById(Integer id);

    /**
     * 通过机房名称获取机房信息
     *
     * @param name 机房名称
     * @return 机房信息
     */
    List<Class> searchClassByName(String name);

    /**
     * 通过实训楼ID称获取机房信息
     *
     * @param buildingId 教学楼id
     * @return 机房信息
     */
    List<Class> searchClassByBuildingId(String buildingId);

    /**
     * 获得机房总数
     *
     * @return 机房总数量
     */
    Integer getClassCount();

    /**
     * 保存机房信息
     *
     * @param classes 机房信息
     */
    void saveClass(Class classes);

    /**
     * 修改你机房信息
     *
     * @param classes 机房信息
     */
    void updateClass(Class classes);

    /**
     * 删除机房信息
     *
     * @param id 机房Id
     */
    void deleteClass(Integer id) throws MySQLIntegrityConstraintViolationException;

    /**
     * 增加实训室可用电脑
     *
     * @param id 机房ID
     */
    void increaseComputerEnable(Integer id);

    /**
     * 减少实训室可用电脑
     *
     * @param id 机房ID
     */
    void reduceComputerEnable(Integer id);

}
