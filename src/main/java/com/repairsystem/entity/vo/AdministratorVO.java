package com.repairsystem.entity.vo;

/**
 * @author CheungChingYin
 * @date 2018/11/3
 * @time 20:07
 */
public class AdministratorVO {

    private Integer adminId;
    private String adminName;
    private String adminPhone;
    private Integer roleId;
    private String adminEmail;

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    @Override
    public String toString() {
        return "AdministratorVO{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminPhone='" + adminPhone + '\'' +
                ", roleId=" + roleId +
                ", adminEmail='" + adminEmail + '\'' +
                '}';
    }
}
