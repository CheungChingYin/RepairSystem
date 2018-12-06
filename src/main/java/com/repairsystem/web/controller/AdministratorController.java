package com.repairsystem.web.controller;

import com.github.pagehelper.PageHelper;
import com.repairsystem.entity.Administrator;
import com.repairsystem.entity.vo.AdministratorVO;
import com.repairsystem.exception.AdministratorIdIsNullException;
import com.repairsystem.exception.PageIsNullException;
import com.repairsystem.service.AdministratorService;
import com.repairsystem.utils.*;
import io.swagger.annotations.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "adminPhoneNum", value = "管理员手机", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "adminPassword", value = "管理员密码", required = true, dataType = "String", paramType = "query")

    })
    @PostMapping("/login")
    public JsonResult login(String adminPhoneNum, String adminPassword) {
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
        try {
            subject.login(token);
        }catch (AccountException e){
            return JsonResult.errorException(e.getMessage());
        }catch (IncorrectCredentialsException e1){
            return JsonResult.errorException(e1.getMessage());
        }
        Administrator admin = adminService.searchAdministratorByPhoneNum(adminPhoneNum);
        AdministratorVO adminVO = Entity2VO.entity2VO(admin,AdministratorVO.class);
        Map<String,Object> resultMap = new HashMap<String, Object>();
        resultMap.put("adminInfo",adminVO);
        return JsonResult.ok(resultMap);
    }

    @ApiOperation(value = "获得全部管理员资料")
    @ApiImplicitParam(name = "page", value = "当前页", required = true, dataType = "String", paramType = "query")
    @GetMapping("/getAllAdminInfo")
    public JsonResult getAllAdminInfo(String page) {

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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "id", value = "管理员ID", required = true, dataType = "String", paramType = "query")
    })
    @GetMapping("/getAdminInfoById")
    public JsonResult getAdminInfoById(String page, Integer id) {
        if (StringUtils.isBlank(id.toString())) {
            throw new AdministratorIdIsNullException("传入的管理员ID为空");
        }
        if (StringUtils.isBlank(page)) {
            throw new PageIsNullException();
        }
        PageHelper.startPage(Integer.parseInt(page), ConstantUtils.Page.PAGESIZE);
        Administrator admin = adminService.searchAdministratorById(id);

        AdministratorVO adminVO = Entity2VO.entity2VO(admin, AdministratorVO.class);
        Map<String, Object> pageMap = PageUtils.pageHandler(page, "1");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageMap", pageMap);
        map.put("Info", adminVO);
        return JsonResult.ok(map);
    }

    @ApiOperation(value = "通过管理员名称获得管理员信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页", required = true, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "adminName", value = "实训楼ID", required = true, dataType = "String", paramType = "query")
    })
    @GetMapping("/getAdminInfoByName")
    public JsonResult getAdminInfoByName(String page, String adminName) {
        if (StringUtils.isBlank(page)) {
            return JsonResult.errorMsg("传入当前页page参数不能为空");
        }
        if (StringUtils.isBlank(adminName)) {
            return JsonResult.errorMsg("传入管理员名称adminName参数不能为空");
        }
        PageHelper.startPage(Integer.parseInt(page), ConstantUtils.Page.PAGESIZE);
        List<Administrator> adminList = adminService.searchAdministratorByName(adminName);

        Map<String, Object> pageMap = PageUtils.pageHandler(page, adminList.size() + "");
        List<AdministratorVO> listVO = Entity2VO.entityList2VOList(adminList, AdministratorVO.class);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("pageMap", pageMap);
        map.put("Info", listVO);
        return JsonResult.ok(map);

    }

    @ApiOperation(value = "保存管理员信息")
    @PostMapping("/saveAdministratorInfo")
    public JsonResult saveAdministratorInfo(@RequestBody Administrator admin) {

        adminService.saveAdministrator(admin);
        return JsonResult.ok();
    }

    @ApiOperation(value = "修改管理员信息")
    @PostMapping("updateAdministratorInfo")
    public JsonResult updateAdministratorInfo(@RequestBody Administrator admin) {
        if (StringUtils.isBlank(admin.getAdminId().toString())) {
            return JsonResult.errorMsg("删除失败，传入的管理员ID不能为空");
        }
        if (StringUtils.isNotBlank(admin.getAdminPassword())){
            String password = admin.getAdminPassword();
            admin.setAdminPassword(PasswordEncryptionUtils.plainText2MD5Encrypt(password));
        }
        adminService.updateAdministrator(admin);
        return JsonResult.ok();
    }

    @ApiOperation(value = "删除管理员信息")
    @GetMapping("deleteAdministratorInfo")
    @ApiImplicitParam(name = "adminId", value = "管理员ID", required = true, dataType = "String", paramType = "query")
    public JsonResult deleteAdministratorInfo(Integer adminId) {
        if (StringUtils.isBlank(adminId.toString())) {
            return JsonResult.errorMsg("删除失败，传入的管理员ID不能为空");
        }
        adminService.deleteAdministrator(adminId);
        return JsonResult.ok();
    }
}
