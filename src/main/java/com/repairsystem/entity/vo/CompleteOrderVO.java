package com.repairsystem.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date completeTime;
    private String imagePath;
    private String className;
    private String buildingName;
    private Integer computerNumber;

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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Integer getComputerNumber() {
        return computerNumber;
    }

    public void setComputerNumber(Integer computerNumber) {
        this.computerNumber = computerNumber;
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
                ", className='" + className + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", computerNumber=" + computerNumber +
                '}';
    }
}
