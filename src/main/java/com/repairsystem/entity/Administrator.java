package com.repairsystem.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;

@ApiModel(value = "管理员对象", description = "这是管理员对象")
public class Administrator {
    /**
     * 管理员ID
     */
    @Id
    @Column(name = "admin_id")
    @ApiModelProperty(value = "管理员ID", name = "adminId", example = "1", required = true)
    private Integer adminId;

    /**
     * 管理员密码
     */
    @Column(name = "admin_password")
    @ApiModelProperty(value = "管理员密码", name = "adminPassword", example = "test123456", required = true)
    private String adminPassword;

    /**
     * 管理员姓名
     */
    @Column(name = "admin_name")
    @ApiModelProperty(value = "管理员姓名", name = "adminName", example = "李四", required = true)
    private String adminName;

    /**
     * 管理员电话
     */
    @Column(name = "admin_phone")
    @ApiModelProperty(value = "管理员电话", name = "adminPhone", example = "13283497593", required = true)
    private String adminPhone;

    /**
     * 管理员权限
     */
    @Column(name = "role_id")
    @ApiModelProperty(value = "管理员权限", name = "roleId", example = "0", required = true)
    private Integer roleId;

    /**
     * 管理员邮箱
     */
    @Column(name = "admin_email")
    @ApiModelProperty(value = "管理员邮箱", name = "adminEmail", example = "test@gmail.com", required = true)
    private String adminEmail;

    /**
     * 获取管理员ID
     *
     * @return admin_id - 管理员ID
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * 设置管理员ID
     *
     * @param adminId 管理员ID
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * 获取管理员密码
     *
     * @return admin_password - 管理员密码
     */
    public String getAdminPassword() {
        return adminPassword;
    }

    /**
     * 设置管理员密码
     *
     * @param adminPassword 管理员密码
     */
    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    /**
     * 获取管理员姓名
     *
     * @return admin_name - 管理员姓名
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * 设置管理员姓名
     *
     * @param adminName 管理员姓名
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    /**
     * 获取管理员电话
     *
     * @return admin_phone - 管理员电话
     */
    public String getAdminPhone() {
        return adminPhone;
    }

    /**
     * 设置管理员电话
     *
     * @param adminPhone 管理员电话
     */
    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    /**
     * 获取管理员权限
     *
     * @return role_id - 管理员权限
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置管理员权限
     *
     * @param roleId 管理员权限
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取管理员邮箱
     *
     * @return admin_email - 管理员邮箱
     */
    public String getAdminEmail() {
        return adminEmail;
    }

    /**
     * 设置管理员邮箱
     *
     * @param adminEmail 管理员邮箱
     */
    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "adminId=" + adminId +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminName='" + adminName + '\'' +
                ", adminPhone='" + adminPhone + '\'' +
                ", roleId=" + roleId +
                ", adminEmail='" + adminEmail + '\'' +
                '}';
    }
}