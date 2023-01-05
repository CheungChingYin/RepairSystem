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
     *
     * @return
     */
    List<Administrator> searchAllAdministrator();

    /**
     * 获得所有管理员数量
     *
     * @return
     */
    String countAllAdministrator();


    /**
     * 按管理员ID搜索管理员
     *
     * @param id 管理员id
     * @return 管理员信息
     */
    Administrator searchAdministratorById(Integer id);

    /**
     * 按照管理员姓名搜索管理员
     *
     * @param name 管理员姓名
     * @return 管理员信息
     */
    List<Administrator> searchAdministratorByName(String name);

    /**
     * 按照手机号搜索管理员
     *
     * @param phoneNum 手机号
     * @return 管理员信息
     */
    Administrator searchAdministratorByPhoneNum(String phoneNum);

    /**
     * 管理员登录
     *
     * @param phone    手机号
     * @param password 密码
     * @return 管理员信息
     */
    Administrator loginAdministrator(String phone, String password);

    /**
     * 查询管理员手机是否存在
     *
     * @param number 手机号
     * @return true为存在
     */
    boolean administratorPhoneNumberIsExist(String number);

    /**
     * 添加管理员
     *
     * @param admin 管理员信息
     */
    void saveAdministrator(Administrator admin);

    /**
     * 修改管理员
     *
     * @param admin 管理员信息
     */
    void updateAdministrator(Administrator admin);

    /**
     * 删除管理员
     *
     * @param id 管理员id
     */
    void deleteAdministrator(Integer id);


}
