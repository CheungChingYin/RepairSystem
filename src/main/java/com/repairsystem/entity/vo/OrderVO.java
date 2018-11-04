package com.repairsystem.entity.vo;

import java.util.Date;

/**
 * @author CheungChingYin
 * @date 2018/11/2
 * @time 21:40
 */
public class OrderVO {

    private Integer orderId;
    private String problem;
    private Integer computerNumber;
    private String className;
    private String buildingName;
    private Integer status;
    private Date submitTime;
    private Date completeTime;
    private String imagesPath;
    private String adminName;
    private String userName;
    private String userPhone;
    private String userEmail;

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

    public Integer getComputerNumber() {
        return computerNumber;
    }

    public void setComputerNumber(Integer computerNumber) {
        this.computerNumber = computerNumber;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Date getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    public String getImagesPath() {
        return imagesPath;
    }

    public void setImagesPath(String imagesPath) {
        this.imagesPath = imagesPath;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "OrderVO{" +
                "orderId=" + orderId +
                ", problem='" + problem + '\'' +
                ", computerNumber=" + computerNumber +
                ", className='" + className + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", status=" + status +
                ", submitTime=" + submitTime +
                ", completeTime=" + completeTime +
                ", imagesPath='" + imagesPath + '\'' +
                ", adminName='" + adminName + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
