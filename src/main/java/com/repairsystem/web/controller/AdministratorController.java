package com.repairsystem.web.controller;

import com.github.pagehelper.PageHelper;
import com.repairsystem.entity.Administrator;
import com.repairsystem.entity.vo.AdministratorVO;
import com.repairsystem.exception.AdministratorIdIsNullException;
import com.repairsystem.exception.PageIsNullException;
import com.repairsystem.service.AdministratorService;
import com.repairsystem.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * @author CheungChingYin
 * @date 2018/11/5
 * @time 17:10
 */
@RestController
@Api(value = "管理员业务相关接口", tags = {"管理员业务相关接口",})
@RequestMapping("/admin")
public class AdministratorController {

    @Autowired
    private AdministratorService adminService;

    @ApiOperation(value = "管理员登录", notes = "管理员登录验证")
    @PostMapping("/login")
    public JsonResult login(@ApiParam("管理员手机") @RequestParam String adminPhoneNum, @ApiParam("管理员密码") @RequestParam String adminPassword) {
        if (StringUtils.isBlank(adminPhoneNum)) {
            return JsonResult.errorMsg("输入的管理员手机号不能为空");
        }
        if (StringUtils.isBlank(adminPassword)) {
            return JsonResult.errorMsg("输入的管理员密码不能为空");
        }
        adminPassword = PasswordEncryptionUtils.plainText2MD5Encrypt(adminPassword);
        //根据管理员手机号和密码创建token
        UsernamePasswordToken token = new UsernamePasswordToken(adminPhoneNum, adminPassword);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        //TODO 设置Redis免登陆
        return JsonResult.ok();
    }

    @ApiOperation(value = "获得全部管理员资料")
    @GetMapping("/getAllAdminInfo")
    public JsonResult getAllAdminInfo(@ApiParam("当前页数") @RequestParam(required = true) String page) {

        if (StringUtils.isBlank(page)) {
            throw new PageIsNullException();
        }

        String count = adminService.countAllAdministrator();

        PageHelper.startPage(Integer.parseInt(page), ConstantUtils.Page.PAGESIZE);
        List<Administrator> list = adminService.searchAllAdministrator();

        Map<String, Object> pageMap = PageUtils.pageHandler(page, count);
        List<AdministratorVO> listVO = Entity2VO.entityList2VOList(list, AdministratorVO.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageMap", pageMap);
        map.put("Info", listVO);

        return JsonResult.ok(map);
    }

    @ApiOperation(value = "通过管理员ID获得管理员信息")
    @GetMapping("/getAdminInfoById")
    public JsonResult getAdminInfoById(@ApiParam("管理员ID") @RequestParam Integer id, @ApiParam("当前页") @RequestParam String page) {
        if (StringUtils.isBlank(id.toString())) {
            throw new AdministratorIdIsNullException("传入的管理员ID为空");
        }
        if (StringUtils.isBlank(page)) {
            throw new PageIsNullException();
        }
        PageHelper.startPage(Integer.parseInt(page),ConstantUtils.Page.PAGESIZE);
        Administrator admin = adminService.searchAdministratorById(id);

        AdministratorVO adminVO = Entity2VO.entity2VO(admin, AdministratorVO.class);
        Map<String, Object> pageMap = PageUtils.pageHandler(page,"1");
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("pageMap",pageMap);
        map.put("Info",adminVO);
        return JsonResult.ok(map);
    }
}
