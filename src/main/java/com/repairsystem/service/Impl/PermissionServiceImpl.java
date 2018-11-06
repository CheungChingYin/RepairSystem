package com.repairsystem.service.Impl;

import com.repairsystem.dao.PermissionMapper;
import com.repairsystem.entity.Permission;
import com.repairsystem.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author CheungChingYin
 * @date 2018/11/5
 * @time 10:53
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Permission> searchAllPermission() {
        return permissionMapper.selectAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Permission> searchPermissionByRoleId(Integer id) {

        Example example = new Example(Permission.class);
        example.createCriteria().andEqualTo("roleId",id);
        return permissionMapper.selectByExample(example);
    }
}
