package com.repairsystem.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class User {
    /**
     * 用户ID
     */
    @Id
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 用户名称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 用户手机号
     */
    @Column(name = "user_phone")
    private String userPhone;

    /**
     * 用户邮箱
     */
    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "open_id")
    private String openId;

    /**
     * 获取用户ID
     *
     * @return user_id - 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取用户名称
     *
     * @return user_name - 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名称
     *
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取用户手机号
     *
     * @return user_phone - 用户手机号
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 设置用户手机号
     *
     * @param userPhone 用户手机号
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * 获取用户邮箱
     *
     * @return user_email - 用户邮箱
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * 设置用户邮箱
     *
     * @param userEmail 用户邮箱
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * @return open_id
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * @param openId
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }
}