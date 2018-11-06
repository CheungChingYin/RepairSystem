package com.repairsystem.realm;

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

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author CheungChingYin
 * @date 2018/11/4
 * @time 21:29
 */
public class AdminRealm extends AuthorizingRealm {

    @Resource
    private AdministratorService adminService;

    @Resource
    private RoleService roleService;

    /**
     * 为当前登录成功的用户授予权限和分配角色
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        System.out.println("======授权认证=======");
        //获得用户手机
        String phoneNum = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Administrator admin = adminService.searchAdministratorByPhoneNum(phoneNum);
        //获得该用户角色
        Role role = roleService.searchRoleById(admin.getRoleId());
        //需要将 role 封装到 Set 作为 info.setRoles() 的参数
        Set<String> set = new HashSet<>();
        set.add(role.getRoleName());
        //设置该用户拥有的角色
        info.setRoles(set);
        return info;



    }

    /**
     * 用来验证当前登录的用户，获取认证信息
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("————身份认证方法————");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //从数据库获得对应的信息
        Administrator admin = adminService.searchAdministratorByPhoneNum(token.getUsername());
        if(null == admin){
            throw new AccountException("管理员手机号不正确");
        }else if(admin.getAdminPassword().equals(token.getPassword())){
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(token.getUsername(),admin.getAdminPassword(),"adminRealm");

    }
}
