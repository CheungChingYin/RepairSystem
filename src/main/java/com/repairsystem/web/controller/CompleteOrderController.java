package com.repairsystem.web.controller;

import com.github.pagehelper.PageHelper;
import com.repairsystem.entity.CompleteOrder;
import com.repairsystem.entity.vo.CompleteOrderVO;
import com.repairsystem.service.CompleteOrderService;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author CheungChingYin
 * @date 2018/11/14
 * @time 16:35
 */
@RestController
@Api(value = "完成维修工单相关接口", tags = {"完成维修工单业务相关接口"})
@RequestMapping("/completeOrders")
public class CompleteOrderController {

    @Autowired
    private CompleteOrderService completeOrderService;

    @ApiOperation(value = "获得所有已完成的维修工单")
    @ApiImplicitParam(name = "page", value = "当前页", required = true, dataType = "String", paramType = "query")
    @GetMapping("getAllCompleteOrderInfo")
    public JsonResult getAllCompleteOrderInfo(String page) {
        if (StringUtils.isBlank(page)) {
            return JsonResult.errorMsg("传入的当前页(page)不能为空");
        }
        PageHelper.startPage(Integer.parseInt(page), ConstantUtils.Page.PAGESIZE);
        List<CompleteOrder> listCompleteOrder = completeOrderService.searchAllCompleteOrder();
        List<CompleteOrderVO> listVO = Entity2VO.entityList2VOList(listCompleteOrder, CompleteOrderVO.class);
        Integer count = completeOrderService.getCompleteOrderCount();
        Map<String, Object> pageMap = PageUtils.pageHandler(page, count.toString());

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("pageMap", pageMap);
        resultMap.put("Info", listVO);
        return JsonResult.ok(resultMap);
    }

    @ApiOperation(value = "通过已完成维修工单ID获得工单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "completeOrderId", value = "已完成维修工单ID", required = true, dataType = "String", paramType = "query")
    })
    @GetMapping("getCompleteOrderInfoById")
    public JsonResult getCompleteOrderInfoById(String page, Integer completeOrderId) {
        if (StringUtils.isBlank(page)) {
            return JsonResult.errorMsg("传入的当前页(page)不能为空");
        }
        if (StringUtils.isBlank(completeOrderId.toString())) {
            return JsonResult.errorMsg("传入的维修工单ID(orderId)不能为空");
        }
        PageHelper.startPage(Integer.parseInt(page), ConstantUtils.Page.PAGESIZE);
        CompleteOrder completeOrder = completeOrderService.searchCompleteOrderById(completeOrderId);

        Map<String, Object> pageMap = PageUtils.pageHandler(page, "1");
        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("pageMap", pageMap);
        resultMap.put("Info", completeOrder);

        return JsonResult.ok(resultMap);
    }

    @ApiOperation(value = "通过关键词搜索已完成维修工单问题")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "keyWord", value = "搜索关键词", required = true, dataType = "String", paramType = "query")
    })
    @GetMapping("getCompleteOrderInfoByKeyWord")
    public JsonResult getCompleteOrderInfoByKeyWord(String page, String keyWord) {
        if (StringUtils.isBlank(page)) {
            return JsonResult.errorMsg("传入的当前页(page)不能为空");
        }
        if (StringUtils.isBlank(keyWord)) {
            return JsonResult.errorMsg("传入的查询关键字(keyWord)不能为空");
        }
        PageHelper.startPage(Integer.parseInt(page), ConstantUtils.Page.PAGESIZE);
        List<CompleteOrder> listCompleteOrder = completeOrderService.searchCompleteOrderByKeyWord(keyWord);
        List<CompleteOrderVO> listVO = Entity2VO.entityList2VOList(listCompleteOrder, CompleteOrderVO.class);

        Map<String, Object> pageMap = PageUtils.pageHandler(page, listCompleteOrder.size() + "");

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("pageMap", pageMap);
        resultMap.put("Info", listVO);
        return JsonResult.ok(resultMap);
    }

    @ApiOperation(value = "更新完成维修工单")
    @PostMapping("/updateCompleteOrder")
    public JsonResult updateCompleteOrder(@RequestBody CompleteOrder completeOrder) {
        if (StringUtils.isBlank(completeOrder.getOrderId().toString())) {
            JsonResult.errorMsg("传入的完成维修工单Id(orderId)不能为空");
        }
        completeOrderService.updateCompleteOrder(completeOrder);
        return JsonResult.ok();
    }

    @ApiOperation(value = "删除完成维修工单")
    @ApiImplicitParam(name = "completeOrderId", value = "已完成维修工单ID", required = true, dataType = "String", paramType = "query")
    @GetMapping("deleteCompleteOrder")
    public JsonResult deleteCompleteOrder(Integer completeOrderId) {
        if (StringUtils.isBlank(completeOrderId.toString())) {
            return JsonResult.errorMsg("传入的维修工单ID(orderId)不能为空");
        }
        completeOrderService.deleteCompleteOrder(completeOrderId);
        return JsonResult.ok();
    }


}
