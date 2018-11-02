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
     * 获取所有完成表单
     * @return
     */
    List<CompleteOrder> searchAllCompleteOrder();

    /**
     * 通过表单Id获取表单信息
     * @param id
     * @return
     */
    CompleteOrder searchCompleteOrderById(Integer id);

    /**
     * 保存已完成表单信息
     * @param completeOrder
     */
    void saveCompleteOrder(CompleteOrder completeOrder);

    /**
     * 更新完成表单信息
     * @param completeOrder
     */
    void updateCompleteOrder(CompleteOrder completeOrder);

    /**
     * 删除完成表单信息
     * @param id
     */
    void deleteCompleteOrder(Integer id);


}
