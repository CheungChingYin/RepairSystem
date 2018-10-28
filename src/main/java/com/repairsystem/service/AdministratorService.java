package com.repairsystem.service;

import com.repairsystem.entity.Administrator;

import java.util.List;

/**
 * @author CheungChingYin
 * @date 2018/10/28
 * @time 19:41
 */
public interface AdministratorService {

    /**
     * 查询所有管理员账户
     * @return
     */
    public List<Administrator> searchAllAdministrator();

    /**
     * 按管理员ID搜索管理员
     * @param id
     * @return
     */
    public Administrator searchAdministratorById(Integer id);

    /**
     * 按照管理员姓名搜索管理员
     * @param name
     * @return
     */
    public List<Administrator> searchAdministratorByName(String name);

    /**
     * 管理员登录
     * @param user
     * @param password
     * @return
     */
    public Administrator loginAdministrator(String user,String password);

    /**
     * 查询管理员手机是否存在
     * @param number
     * @return
     */
    public boolean administratorPhoneNumberIsExist(String number);

    /**
     * 添加管理员
     * @param admin
     */
    public void saveAdministrator(Administrator admin);

    /**
     * 修改管理员
     * @param admin
     */
    public void updateAdministrator(Administrator admin);

    /**
     * 删除管理员
     * @param id
     */
    public void deleteAdministrator(Integer id);


}
