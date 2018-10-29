package com.repairsystem.service;

import com.repairsystem.entity.Orders;

import java.util.List;

/**
 * @author CheungChingYin
 * @date 2018/10/29
 * @time 8:43
 */
public interface OrdersService {

    /**
     * 获取全部维修单
     * @return
     */
    public List<Orders> searchAllOrder();

    /**
     * 按照维修单号搜索维修单
     * @param id
     * @return
     */
    public Orders searchOrderById(Integer id);

    /**
     * 添加维修单
     * @param orders
     *
     */
    public void saveOrder(Orders order);

    /**
     * 更新维修单
     * @param order
     */
    public void updateOrder(Orders order);

    /**
     * 删除维修单
     * @param id
     */
    public void deleteOrder(Integer id);
}
