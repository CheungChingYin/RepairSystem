package com.repairsystem.web.controller;

import com.repairsystem.entity.Administrator;
import com.repairsystem.service.AdministratorService;
import com.repairsystem.utils.JsonResult;
import com.repairsystem.utils.PasswordEncryptionUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * @author CheungChingYin
 * @date 2018/11/5
 * @time 17:10
 */
@RestController
@Api(value = "管理员业务相关接口",tags = {"管理员业务相关接口",})
@RequestMapping("/admin")
public class AdministratorController {

    @Autowired
    private AdministratorService adminService;

    @ApiOperation(value = "管理员登录",notes = "管理员登录验证")
    @PostMapping("/login")
    public JsonResult login(@ApiParam("管理员手机") @RequestParam String adminPhoneNum, @ApiParam("管理员密码") @RequestParam String adminPassword){
        if(StringUtils.isBlank(adminPhoneNum)){
            return JsonResult.errorMsg("输入的管理员手机号不能为空");
        }
        if(StringUtils.isBlank(adminPassword)){
            return JsonResult.errorMsg("输入的管理员密码不能为空");
        }
        adminPassword = PasswordEncryptionUtils.plainText2MD5Encrypt(adminPassword);
        //根据管理员手机号和密码创建token
        UsernamePasswordToken token = new UsernamePasswordToken(adminPhoneNum,adminPassword);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        //TODO 设置Redis免登陆
        return JsonResult.ok();

    }
}
