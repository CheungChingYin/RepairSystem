package com.repairsystem.web.controller;

import com.repairsystem.entity.Administrator;
import com.repairsystem.service.AdministratorService;
import com.repairsystem.utils.JsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author CheungChingYin
 * @date 2018/11/5
 * @time 17:10
 */
@Controller
@Api(value = "管理员业务相关接口",tags = {"管理员业务相关接口",})
@RequestMapping("/admin")
public class AdministratorController {

    @Autowired
    private AdministratorService adminService;

    @ApiOperation(value = "管理员登录",notes = "管理员登录验证")
    @PostMapping("/login")
    public JsonResult login(@RequestBody Administrator admin){
        if(StringUtils.isBlank(admin.getAdminPhone())){
            return JsonResult.errorMsg("输入的管理员手机号不能为空");
        }
        if(StringUtils.isBlank(admin.getAdminPassword())){
            return JsonResult.errorMsg("输入的管理员密码不能为空");
        }
        //根据管理员手机号和密码创建token
        UsernamePasswordToken token = new UsernamePasswordToken(admin.getAdminPhone(),admin.getAdminPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        //TODO 设置Redis免登陆
        return JsonResult.ok();

    }
}
