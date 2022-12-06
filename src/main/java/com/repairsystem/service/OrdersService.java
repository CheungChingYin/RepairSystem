package com.repairsystem.service;

import com.repairsystem.entity.Orders;
import com.repairsystem.entity.vo.OrderVO;

import java.util.List;

/**
 * @author CheungChingYin
 * @date 2018/10/29
 * @time 8:43
 */
public interface OrdersService {

    /**
     * 获取全部工单
     *
     * @return 工单信息
     */
    List<Orders> searchAllOrder();

    /**
     * 按照工单号搜索工单
     *
     * @param id 工单Id
     * @return 工单信息
     */
    Orders searchOrderById(Integer id);

    /**
     * 获得工单总数量
     *
     * @return 工单数量
     */
    Integer getOrderCount();

    /**
     * 添加工单
     *
     * @param order 工单信息
     */
    void saveOrder(Orders order);

    /**
     * 更新工单
     *
     * @param order 工单信息
     */
    void updateOrder(Orders order);

    /**
     * 删除工单
     *
     * @param id 工单id
     */
    void deleteOrder(Integer id);

}
