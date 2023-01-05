package com.repairsystem.dao;

import com.repairsystem.entity.Administrator;
import com.repairsystem.utils.MyMapper;

public interface AdministratorMapper extends MyMapper<Administrator> {

    /**
     * 获得管理员数量
     *
     * @return
     */
    Integer getAdministratorCount();
}