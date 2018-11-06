package com.repairsystem.service;

import com.repairsystem.entity.Permission;

import java.util.List;

/**
 * @author CheungChingYin
 * @date 2018/11/5
 * @time 10:46
 */
public interface PermissionService {

    /**
     * 获取全部权限信息
     * @return
     */
    List<Permission> searchAllPermission();

    /**
     * 通过角色ID获取权限信息
     * @param id
     * @return
     */
    List<Permission> searchPermissionByRoleId(Integer id);
}
