package com.repairsystem.service;

import com.repairsystem.entity.Class;

import java.util.List;

/**
 * @author CheungChingYin
 * @date 2018/10/31
 * @time 12:03
 */
public interface ClassService {

    /**
     * 获取全部机房信息
     * @return
     */
    List<Class> searchAllClass();

    /**
     * 通过机房ID获取机房信息
     * @param id
     * @return
     */
    Class searchClassById(Integer id);

    /**
     * 通过机房名称获取机房信息
     * @param name
     * @return
     */
    List<Class> searchClassByName(String name);

    /**
     * 保存机房信息
     * @param classes
     */
    void saveClass(Class classes);

    /**
     * 修改你机房信息
     * @param classes
     */
    void updateClass(Class classes);

    /**
     * 删除机房信息
     * @param id
     */
    void deleteClass(Integer id);

    /**
     * 增加实训室可用电脑
     * @param id
     */
    void increaseComputerEnable(Integer id);

    /**
     * 减少实训室可用电脑
     * @param id
     */
    void reduceCompleteEnable(Integer id);

}
