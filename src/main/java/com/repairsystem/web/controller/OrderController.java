package com.repairsystem.web.controller;

import com.github.pagehelper.PageHelper;
import com.repairsystem.entity.Orders;
import com.repairsystem.entity.vo.OrderVO;
import com.repairsystem.service.ClassService;
import com.repairsystem.service.OrdersService;
import com.repairsystem.utils.ConstantUtils;
import com.repairsystem.utils.Entity2VO;
import com.repairsystem.utils.JsonResult;
import com.repairsystem.utils.PageUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CheungChingYin
 * @date 2018/11/12
 * @time 16:25
 */
@RestController
@Api(value = "维修工单相关接口", tags = {"维修工单业务相关接口"})
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ClassService classService;

    @ApiOperation(value = "获得所有维修工单信息")
    @ApiImplicitParam(name = "page", value = "当前页", required = true, dataType = "String", paramType = "query")
    @GetMapping("/getAllOrdersInfo")
    public JsonResult getAllOrdersInfo(String page) {
        if (StringUtils.isBlank(page)) {
            return JsonResult.errorMsg("传入的当前页(page)不能为空");
        }
        PageHelper.startPage(Integer.parseInt(page), ConstantUtils.Page.PAGESIZE);
        List<Orders> listOrder = ordersService.searchAllOrder();
        List<OrderVO> listVO = Entity2VO.entityList2VOList(listOrder, OrderVO.class);

        Integer count = ordersService.getOrderCount();
        Map<String, Object> pageMap = PageUtils.pageHandler(page, count.toString());

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("pageMap", pageMap);
        resultMap.put("Info", listOrder);
        return JsonResult.ok(resultMap);
    }

    @ApiOperation(value = "通过维修工单ID获得工单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "orderId", value = "维修工单ID", required = true, dataType = "String", paramType = "query")
    })
    @GetMapping("/getOrdersInfoById")
    public JsonResult getOrdersInfoById(String page, Integer orderId) {
        if (StringUtils.isBlank(page)) {
            return JsonResult.errorMsg("传入的当前页(page)不能为空");
        }
        if (StringUtils.isBlank(orderId.toString())) {
            return JsonResult.errorMsg("传入的维修工单ID(orderId)不能为空");
        }

        PageHelper.startPage(Integer.parseInt(page), ConstantUtils.Page.PAGESIZE);
        Orders orders = ordersService.searchOrderById(orderId);

        Map<String, Object> pageMap = PageUtils.pageHandler(page, "1");
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("pageMap", pageMap);
        resultMap.put("Info", orders);

        return JsonResult.ok(resultMap);
    }

    @ApiOperation(value = "保存维修工单")
    @PostMapping("/saveOrders")
    public JsonResult saveOrders(@RequestBody Orders orders) {
        if (StringUtils.isBlank(orders.getClassId().toString())) {
            JsonResult.errorMsg("传入的实训室ID(classId)不能为空");
        }
        orders.setSubmitTime(new Date());
        ordersService.saveOrder(orders);
        classService.reduceComputerEnable(orders.getClassId());
        return JsonResult.ok();
    }
}
