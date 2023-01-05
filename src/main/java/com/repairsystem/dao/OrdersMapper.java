package com.repairsystem.dao;

import com.repairsystem.entity.Orders;
import com.repairsystem.entity.vo.OrderVO;
import com.repairsystem.utils.MyMapper;

import java.util.List;

public interface OrdersMapper extends MyMapper<Orders> {

    /**
     * 获得所有订单信息
     *
     * @return 订单信息
     */
    List<Orders> getAllOrder();

    /**
     * 根据工单Id获得工单信息
     *
     * @param odrderId 工单id
     * @return 工单信息
     */
    Orders getOrderById(Integer odrderId);

    /**
     * 获得工单数量
     *
     * @return 工单数量
     */
    Integer getOrdersCount();
}