package com.repairsystem.entity.vo;

import java.util.Date;

/**
 * @author CheungChingYin
 * @date 2018/11/2
 * @time 21:37
 */
public class CompleteOrderVO {

    private Integer orderId;
    private String problem;
    private String remark;
    private String adminName;
    private Date completeTime;
    private String imagePath;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "CompleteOrderVO{" +
                "orderId=" + orderId +
                ", problem='" + problem + '\'' +
                ", remark='" + remark + '\'' +
                ", adminName='" + adminName + '\'' +
                ", completeTime=" + completeTime +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
