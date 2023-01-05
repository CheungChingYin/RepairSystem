package com.repairsystem.dao;

import com.repairsystem.entity.CompleteOrder;
import com.repairsystem.utils.MyMapper;

import java.util.List;

public interface CompleteOrderMapper extends MyMapper<CompleteOrder> {

    /**
     * 获得所有已完成的工单
     *
     * @return 工单列表
     */
    List<CompleteOrder> getAllCompleteOrder();

    /**
     * 根据工单id获得已完成的工单
     *
     * @param id 工单id
     * @return 已完成工单信息
     */
    CompleteOrder getCompleteOrderById(Integer id);

    /**
     * 获得已完成工单总数
     *
     * @return 已完成工单信息
     */
    Integer getCompleteOrderCount();

    /**
     * 更具关键词获得已完成工单信息
     *
     * @param keyWord 关键词
     * @return 已完成工单信息
     */
    List<CompleteOrder> getCompleteOrderByKeyWord(String keyWord);
}