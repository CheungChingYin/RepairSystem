package com.repairsystem.utils;

import org.springframework.beans.BeanUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * @author CheungChingYin
 * @date 2018/11/7
 * @time 10:17
 */
public class Entity2VO {

    /**
     * 实体类列表转换为 VO类列表
     * @param entityList
     * @param voClass
     * @return
     */
    public static List entityList2VOList(List<? extends Object> entityList, Class voClass){
        List voList = new LinkedList();
        Object voObj = null;
        for(Object entityObj:entityList){
            try {
                voObj = voClass.newInstance();

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            BeanUtils.copyProperties(entityObj,voObj);
            voList.add(voObj);
        }
        return voList;
    }

    /**
     * 实体类转换为 VO类
     * @param entity
     * @param voClass
     * @param <T>
     * @return
     */
    public static <T> T entity2VO(Object entity,Class<T> voClass){
        T vo = null;
        try {
            vo = voClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        BeanUtils.copyProperties(entity,vo);
        return vo;
    }
}
