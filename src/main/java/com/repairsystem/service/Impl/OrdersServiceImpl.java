package com.repairsystem.service.Impl;

import com.repairsystem.dao.OrdersMapper;
import com.repairsystem.entity.Orders;
import com.repairsystem.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author CheungChingYin
 * @date 2018/10/29
 * @time 15:15
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    OrdersMapper ordersMapper;

    @Override
    public List<Orders> searchAllOrder() {

        return ordersMapper.selectAll();
    }

    @Override
    public Orders searchOrderById(Integer id) {

        return ordersMapper.selectByPrimaryKey(id);
    }

    @Override
    public void saveOrder(Orders order) {

        ordersMapper.insertSelective(order);
    }

    @Override
    public void updateOrder(Orders order) {

        ordersMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public void deleteOrder(Integer id) {

        ordersMapper.deleteByPrimaryKey(id);
    }
}
