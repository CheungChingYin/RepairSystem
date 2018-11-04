package com.repairsystem.service.Impl;

import com.repairsystem.dao.OrdersMapper;
import com.repairsystem.entity.Orders;
import com.repairsystem.entity.vo.OrderVO;
import com.repairsystem.exception.OrderIdIsNullException;
import com.repairsystem.service.OrdersService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Collections;
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

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Orders> searchAllOrder() {

       return ordersMapper.getAllOrder();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Orders searchOrderById(Integer id) {

        if (StringUtils.isBlank(id.toString())) {
            throw new OrderIdIsNullException("传入的订单ID为空");
        }
        return ordersMapper.getOrderById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void saveOrder(Orders order) {

        ordersMapper.insertSelective(order);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public void updateOrder(Orders order) {

        ordersMapper.updateByPrimaryKeySelective(order);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public void deleteOrder(Integer id) {

        if (StringUtils.isBlank(id.toString())) {
            throw new OrderIdIsNullException("传入的订单ID为空");
        }
        ordersMapper.deleteByPrimaryKey(id);
    }
}
