package com.repairsystem.service;

import com.repairsystem.entity.CompleteOrder;
import com.repairsystem.entity.Orders;

import java.util.List;

/**
 * @author CheungChingYin
 * @date 2018/10/29
 * @time 20:41
 */
public interface CompleteOrderService {

    /**
     * 获取所有完成工单
     * @return 完成工单信息
     */
    List<CompleteOrder> searchAllCompleteOrder();

    /**
     * 获取完成维修工单数量
     * @return 完成工单数量
     */
    Integer getCompleteOrderCount();

    /**
     * 通过工单Id获取工单信息
     * @param id 工单ID
     * @return 完成工单数量
     */
    CompleteOrder searchCompleteOrderById(Integer id);

    /**
     * 通过关键字搜索完成维修工单
     * @param keyWord 关键词
     * @return 完成工单信息
     */
    List<CompleteOrder> searchCompleteOrderByKeyWord(String keyWord);

    /**
     * 保存已完成工单信息
     * @param completeOrder 完成工单信息
     */
    void saveCompleteOrder(CompleteOrder completeOrder);

    /**
     * 更新完成工单信息
     * @param completeOrder 完成工单信息
     */
    void updateCompleteOrder(CompleteOrder completeOrder);

    /**
     * 删除完成工单信息
     * @param id 工单Id
     */
    void deleteCompleteOrder(Integer id);


}
