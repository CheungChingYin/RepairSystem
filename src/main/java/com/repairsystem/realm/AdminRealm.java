package com.repairsystem.realm;

import com.repairsystem.entity.Administrator;
import com.repairsystem.entity.Permission;
import com.repairsystem.entity.Role;
import com.repairsystem.service.AdministratorService;
import com.repairsystem.service.PermissionService;
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
 * @author CheungChingYin
 * @date 2018/11/4
 * @time 21:29
 */
public class AdminRealm extends AuthorizingRealm {

    @Resource
    private AdministratorService adminService;

    @Resource
    private PermissionService permissionService;

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

        //获得用户手机
        String phoneNum = (String) principalCollection.getPrimaryPrincipal();
        Administrator admin = adminService.searchAdministratorByPhoneNum(phoneNum);
        Role role = roleService.searchRoleById(admin.getRoleId());
        List<Permission> permissionList = permissionService.searchPermissionByRoleId(admin.getRoleId());

        Set<String> roleSet = new HashSet<>();
        roleSet.add(role.getRoleName());
        Set<String> permissionSet = new HashSet<>();
        for (Permission p : permissionList) {
            permissionSet.add(p.getPermissionName());
        }

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(roleSet);
        authorizationInfo.setRoles(permissionSet);

        return authorizationInfo;

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

        //通过Token获取管理员手机号
        String adminPhoneNum = (String) authenticationToken.getPrincipal();
        //根据管理员手机号查询管理员信息
        Administrator admin = adminService.searchAdministratorByPhoneNum(adminPhoneNum);
        if (admin != null) {
            SecurityUtils.getSubject().getSession().setAttribute("admin", admin);
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(admin.getAdminPhone(), admin.getAdminPassword(), "AdminRealm");
            return authcInfo;
        } else {
            return null;
        }

    }
}
