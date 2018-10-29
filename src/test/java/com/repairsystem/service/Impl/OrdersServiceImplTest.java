package com.repairsystem.service.Impl;

import com.repairsystem.RepairsystemApplication;
import com.repairsystem.entity.Orders;
import com.repairsystem.service.OrdersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * @author CheungChingYin
 * @date 2018/10/29
 * @time 15:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RepairsystemApplication.class)
public class OrdersServiceImplTest {

    @Autowired
    OrdersService ordersService;

    @Test
    public void searchAllOrder() {
        List<Orders> list = ordersService.searchAllOrder();
        for(Orders order:list){
            System.out.println(order.getUserName());
        }
    }

    @Test
    public void searchOrderById() {
        Orders orders = ordersService.searchOrderById(2);
        System.out.println(orders.getUserName());
    }

    @Test
    public void saveOrder() {
        Orders order = new Orders();
        order.setProblem("电脑出现问题");
        order.setComputerNumber(11);
        order.setClassId(4);
        order.setBuildingId(3);
        order.setStatus(1);
        order.setSubmitTime(new Date());
        order.setUserName("杜甫");
        order.setUserPhone("13581432451");
        order.setUserEmail("test@outlook.com");
        ordersService.saveOrder(order);
    }

    @Test
    public void updateOrder() {
        Orders orders = new Orders();
        orders.setOrderId(1);
        orders.setCompleteTime(new Date());
        orders.setAdminId(2);
        ordersService.updateOrder(orders);
    }

    @Test
    public void deleteOrder() {
        ordersService.deleteOrder(2);
    }
}