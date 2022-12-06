package com.repairsystem.config.shiro;

import com.repairsystem.entity.Administrator;
import com.repairsystem.entity.Role;
import com.repairsystem.service.AdministratorService;
import com.repairsystem.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * shiro 认证类
 *
 * @author CheungChingYin
 * @date 2018/11/4
 * @time 21:29
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private AdministratorService adminService;

    @Autowired
    private RoleService roleService;

    public MyShiroRealm() {
    }

    /**
     * 为当前登录成功的用户授予权限和分配角色
     *
     * @param principalCollection 认证数据
     * @return 认证信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("======授权认证=======");
        //获得用户手机好
        String phoneNum = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Administrator admin = adminService.searchAdministratorByPhoneNum(phoneNum);
        //获得该用户角色
        Role role = roleService.searchRoleById(admin.getRoleId());
        //需要将 role 封装到 Set 作为 info.setRoles() 的参数
        Set<String> set = new HashSet<>();
        set.add(role.getRoleName());
        //设置该用户拥有的角色
        info.addRoles(set);
        return info;
    }

    /**
     * 用来验证当前登录的用户，获取认证信息
     *
     * @param authenticationToken 认证token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("————身份认证方法————");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //从数据库获得对应的信息
        Administrator admin = adminService.searchAdministratorByPhoneNum(token.getUsername());
        // 根据手机号找不到数据
        if (null == admin) {
            throw new AccountException("管理员手机号不正确");
        } else if (admin.getAdminPassword().equals(token.getPassword())) {
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(token.getUsername(), admin.getAdminPassword(), "adminRealm");

    }
}
