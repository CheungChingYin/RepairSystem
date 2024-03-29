package com.repairsystem.web.controller;

import com.github.pagehelper.PageHelper;
import com.repairsystem.config.LoginAdminContext;
import com.repairsystem.entity.CompleteOrder;
import com.repairsystem.entity.Orders;
import com.repairsystem.entity.vo.OrderVO;
import com.repairsystem.service.ClassService;
import com.repairsystem.service.CompleteOrderService;
import com.repairsystem.service.EmailService;
import com.repairsystem.service.OrdersService;
import com.repairsystem.utils.*;
import com.sun.xml.internal.bind.v2.TODO;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    private CompleteOrderService completeOrderService;

    @Autowired
    private EmailService emailService;

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);



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
        resultMap.put("Info", listVO);
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

    @ApiOperation(value = "上传工单图片")
    @PostMapping(value = "/uploadImage")
    public JsonResult uploadImage(@ApiParam(value = "图片上传") MultipartFile file) {
        if (!file.isEmpty()) {
            String dbPath = null;
            Map<String, String> map = OrderUploadUtils.upLoadOrderImage(file);
            if (map.get("success") != null) {
                dbPath = map.get("success");
                return JsonResult.ok(dbPath);
            } else {
                return JsonResult.errorMsg(map.get("failure"));
            }
        } else {
            return null;
        }
    }

    @ApiOperation(value = "保存维修工单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "problem", value = "维修工单问题", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "computerNumber", value = "维修电脑编号", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "classId", value = "所属实训室编号", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "buildingId", value = "所属实训楼编号", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "userName", value = "报修人名称", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "userPhone", value = "报修人电话", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "userEmail", value = "报修人邮箱", required = true, dataType = "String", paramType = "form"),
            @ApiImplicitParam(name = "imagePath", value = "图片地址", required = true, dataType = "String", paramType = "form"),
    })
    @PostMapping(value = "/saveOrders")
    public JsonResult saveOrders(String problem, Integer computerNumber, Integer classId, Integer buildingId, String userName, String userPhone, String userEmail, String imagePath) {
        if (StringUtils.isBlank(classId.toString())) {
            JsonResult.errorMsg("传入的实训室ID(classId)不能为空");
        }
        Orders orders = new Orders();

        orders.setImagesPath(imagePath);
        orders.setProblem(problem);
        orders.setComputerNumber(computerNumber);
        orders.setClassId(classId);
        orders.setBuildingId(buildingId);
        orders.setStatus(0);//刚提交维修工单状态是未维修状态0
        orders.setUserName(userName);
        orders.setUserPhone(userPhone);
        orders.setUserEmail(userEmail);
        orders.setSubmitTime(new Date());

        ordersService.saveOrder(orders);
        classService.reduceComputerEnable(orders.getClassId());
        simpMessagingTemplate.convertAndSend(ConstantUtils.WebSocket.BROADCAST_PREFIX
                + ConstantUtils.WebSocket.RECEIVE_ORDER_TOPIC, ConstantUtils.WebSocket.RECEIVE_ORDER_MESSAGE);
        return JsonResult.ok();
    }

    @ApiOperation(value = "修改维修工单")
    @PostMapping("/updateOrders")
    public JsonResult updateOrders(@RequestBody Orders orders) {
        if (StringUtils.isBlank(orders.getOrderId().toString())) {
            return JsonResult.errorMsg("传入的维修工单ID(orderId)不能为空");
        }
        ordersService.updateOrder(orders);
        return JsonResult.ok();
    }

    @ApiOperation(value = "删除维修工单")
    @ApiImplicitParam(name = "orderId", value = "维修工单ID", required = true, dataType = "String", paramType = "query")
    @GetMapping("/deleteOrders")
    public JsonResult deleteOrders(Integer orderId) {
        if (StringUtils.isBlank(orderId.toString())) {
            return JsonResult.errorMsg("传入的维修工单ID(orderId)不能为空");
        }
        ordersService.deleteOrder(orderId);
        return JsonResult.ok();
    }

    @ApiOperation(value = "接受维修工单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "维修工单ID", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "adminId", value = "接受维修工单管理员ID", required = true, dataType = "String", paramType = "query"),
    })
    @GetMapping("/receiveOrder")
    public JsonResult receiveOrder(Integer orderId, Integer adminId) {
        Orders orderInfo = ordersService.searchOrderById(orderId);
        Orders order = new Orders();
        order.setOrderId(orderId);
        order.setAdminId(adminId);
        order.setStatus(1);
        ordersService.updateOrder(order);
        String emailResult = emailService.acceptOrderMail(orderInfo.getUserName(), orderInfo.getUserEmail());
        if (!"OK".equals(emailResult)) {
           log.error("【发送邮件失败】：工单Id" + orderId);
        }
        return JsonResult.ok();
    }

    @ApiOperation(value = "完成维修工单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "维修工单ID", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "remark", value = "维修备注", dataType = "Long", paramType = "query")
    })

    @PostMapping("/orderComplete")
    public JsonResult orderComplete(Integer orderId, String remark) {
        if (StringUtils.isBlank(orderId.toString())) {
            return JsonResult.errorMsg("传入的维修工单ID(orderId)不能为空");
        }
        Orders order = ordersService.searchOrderById(orderId);
        CompleteOrder completeOrder = Entity2VO.entity2VO(order, CompleteOrder.class);
        if (StringUtils.isNoneBlank(remark)) {
            completeOrder.setRemark(remark);
        }
        completeOrder.setImagePath(order.getImagesPath());
        completeOrder.setCompleteTime(new Date());
        completeOrder.setAdminName(null);
        completeOrder.setClassName(null);
        completeOrder.setBuildingName(null);
        completeOrderService.saveCompleteOrder(completeOrder);
        ordersService.deleteOrder(orderId);
        classService.increaseComputerEnable(order.getClassId());
        String emailResult = emailService.completeOrderMail(order.getUserName(), order.getUserEmail());
        if (!"OK".equals(emailResult)) {
            return JsonResult.errorMsg("邮件发送失败");
        }
        return JsonResult.ok();

    }
}
