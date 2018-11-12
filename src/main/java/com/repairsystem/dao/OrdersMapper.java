package com.repairsystem.dao;

import com.repairsystem.entity.Orders;
import com.repairsystem.entity.vo.OrderVO;
import com.repairsystem.utils.MyMapper;

import java.util.List;

public interface OrdersMapper extends MyMapper<Orders> {

    List<Orders> getAllOrder();
    Orders getOrderById(Integer odrderId);
    Integer getOrdersCount();
}