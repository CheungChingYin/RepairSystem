package com.repairsystem.service.Impl;

import com.repairsystem.RepairsystemApplication;
import com.repairsystem.dao.CompleteOrderMapper;
import com.repairsystem.entity.CompleteOrder;
import com.repairsystem.entity.Orders;
import com.repairsystem.service.CompleteOrderService;
import com.repairsystem.service.OrdersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author CheungChingYin
 * @date 2018/10/29
 * @time 21:55
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RepairsystemApplication.class)
public class CompleteOrderServiceImplTest {

    @Autowired
    private CompleteOrderService completeOrderService;

    @Autowired
    private OrdersService ordersService;

    @Test
    public void searchAllCompleteOrder() {

        List<CompleteOrder> list = completeOrderService.searchAllCompleteOrder();
        for (CompleteOrder completeOrder : list){
            System.out.println(completeOrder.toString());
        }
    }

    @Test
    public void searchCompleteOrderById() {
        CompleteOrder completeOrder = completeOrderService.searchCompleteOrderById(2);
        System.out.println(completeOrder.toString());
    }

    @Test
    public void saveCompleteOrder() {
        Orders orders = ordersService.searchOrderById(3);
        CompleteOrder completeOrder = new CompleteOrder();
        completeOrder.setProblem(orders.getProblem());
        completeOrder.setRemark("已修复");
        completeOrder.setCompleteTime(orders.getCompleteTime());
        completeOrder.setAdminId(orders.getAdminId());
        completeOrder.setImagePath("/test/test01.jpg");
        completeOrderService.saveCompleteOrder(completeOrder);
    }

    @Test
    public void updateCompleteOrder() {
        CompleteOrder completeOrder = new CompleteOrder();
        completeOrder.setOrderId(1);
        completeOrder.setRemark("反倒是覅很舒服");
        completeOrderService.updateCompleteOrder(completeOrder);
    }

    @Test
    public void deleteCompleteOrder() {
    }
}