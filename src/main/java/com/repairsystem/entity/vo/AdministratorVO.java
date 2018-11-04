package com.repairsystem.entity.vo;

/**
 * @author CheungChingYin
 * @date 2018/11/3
 * @time 20:07
 */
public class AdministratorVO {

    private Integer adminId;
    private String adminName;
    private Integer adminPermission;

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

    public Integer getAdminPermission() {
        return adminPermission;
    }

    public void setAdminPermission(Integer adminPermission) {
        this.adminPermission = adminPermission;
    }

    @Override
    public String toString() {
        return "AdministratorVO{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminPermission=" + adminPermission +
                '}';
    }
}
