package com.repairsystem.service.Impl;

import com.repairsystem.dao.RoleMapper;
import com.repairsystem.entity.Role;
import com.repairsystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author CheungChingYin
 * @date 2018/11/5
 * @time 10:43
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Role> searchAllRole() {
        return roleMapper.selectAll();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Role searchRoleById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }
}
