package com.repairsystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Orders {
    /**
     * 工单ID
     */
    @Id
    @Column(name = "order_id")
    @ApiModelProperty(value = "维修工单ID", name = "orderId", required = true)
    private Integer orderId;

    /**
     * 电脑序号
     */
    @Column(name = "computer_number")
    @ApiModelProperty(value = "出现问题的电脑编号", name = "computerNumber", example = "1", required = true)
    private Integer computerNumber;

    /**
     * 所属教室ID
     */
    @Column(name = "class_id")
    @ApiModelProperty(value = "所属实训室ID", name = "classId", example = "1", required = true)
    private Integer classId;

    /**
     * 所属实训室名称
     */
    @ApiModelProperty(hidden = true)
    private String className;

    /**
     * 所属实训楼ID
     */
    @Column(name = "building_id")
    @ApiModelProperty(value = "所属实训楼ID",name = "buildingId",example = "1",required = true)
    private Integer buildingId;

    /**
     * 所属实训楼名称
     */
    @ApiModelProperty(hidden = true)
    private String buildingName;

    /**
     * 维修状态
     */
    @ApiModelProperty(value = "维修状态",name = "status",example = "0",required = true)
    private Integer status;

    /**
     * 提交时间
     */
    @Column(name = "submit_time")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(hidden = true)
    private Date submitTime;


    /**
     * 故障图片上传
     */
    @Column(name = "images_path")
    @ApiModelProperty(value = "故障图片",name = "imagesPath")
    private String imagesPath;

    /**
     * 接手管理员ID
     */
    @Column(name = "admin_id")
    @ApiModelProperty(value = "经手管理员ID",name = "adminId",example = "1",required = true)
    private Integer adminId;

    /**
     * 接收管理员名称
     */
    @ApiModelProperty(hidden = true)
    private String adminName;

    /**
     * 报修人名称
     */
    @ApiModelProperty(value = "报修人名称",name = "userName",example = "王翠花",required = true)
    @Column(name = "user_name")
    private String userName;

    /**
     * 报修人电话
     */
    @ApiModelProperty(value = "报修人电话号码" ,name = "userPhone",example = "13525874610",required = true)
    @Column(name = "user_phone")
    private String userPhone;

    /**
     * 报修人邮箱
     */
    @Column(name = "user_email")
    @ApiModelProperty(value = "报修人邮箱",name = "userEmail",example = "user@abc.com",required = true)
    private String userEmail;

    /**
     * 工单问题
     */
    @ApiModelProperty(value = "维修工单问题",name = "problem",example = "电脑出现问题",required = true)
    private String problem;

    /**
     * 获取工单ID
     *
     * @return order_id - 工单ID
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 设置工单ID
     *
     * @param orderId 工单ID
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取电脑序号
     *
     * @return computer_number - 电脑序号
     */
    public Integer getComputerNumber() {
        return computerNumber;
    }

    /**
     * 设置电脑序号
     *
     * @param computerNumber 电脑序号
     */
    public void setComputerNumber(Integer computerNumber) {
        this.computerNumber = computerNumber;
    }

    /**
     * 获取所属教室ID
     *
     * @return class_id - 所属教室ID
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * 设置所属教室ID
     *
     * @param classId 所属教室ID
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * 获得所属实训室名称
     *
     * @return
     */
    public String getClassName() {
        return className;
    }

    /**
     * 设置所属实训室名称
     *
     * @param className
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 获取所属实训楼ID
     *
     * @return building_id - 所属实训楼ID
     */
    public Integer getBuildingId() {
        return buildingId;
    }

    /**
     * 设置所属实训楼ID
     *
     * @param buildingId 所属实训楼ID
     */
    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    /**
     * 获得所属实训楼名称
     *
     * @return
     */
    public String getBuildingName() {
        return buildingName;
    }

    /**
     * 设置所属实训楼名称
     *
     * @param buildingName
     */
    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取提交时间
     *
     * @return submit_time - 提交时间
     */
    public Date getSubmitTime() {
        return submitTime;
    }

    /**
     * 设置提交时间
     *
     * @param submitTime 提交时间
     */
    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    /**
     * 获取故障图片上传
     *
     * @return images_path - 故障图片上传
     */
    public String getImagesPath() {
        return imagesPath;
    }

    /**
     * 设置故障图片上传
     *
     * @param imagesPath 故障图片上传
     */
    public void setImagesPath(String imagesPath) {
        this.imagesPath = imagesPath;
    }

    /**
     * 获取接手管理员ID
     *
     * @return admin_id - 接手管理员ID
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * 设置接手管理员ID
     *
     * @param adminId 接手管理员ID
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * 获得接收管理员名称
     *
     * @return adminName
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * 设置接手管理员名称
     *
     * @param adminName
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    /**
     * 获取报修人名称
     *
     * @return user_name - 报修人名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置报修人名称
     *
     * @param userName 报修人名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取报修人电话
     *
     * @return user_phone - 报修人电话
     */
    public String getUserPhone() {
        return userPhone;
    }

    /**
     * 设置报修人电话
     *
     * @param userPhone 报修人电话
     */
    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * 获取报修人邮箱
     *
     * @return user_email - 报修人邮箱
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * 设置报修人邮箱
     *
     * @param userEmail 报修人邮箱
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * 获取工单问题
     *
     * @return problem - 工单问题
     */
    public String getProblem() {
        return problem;
    }

    /**
     * 设置工单问题
     *
     * @param problem 工单问题
     */
    public void setProblem(String problem) {
        this.problem = problem;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", computerNumber=" + computerNumber +
                ", classId=" + classId +
                ", className='" + className + '\'' +
                ", buildingId=" + buildingId +
                ", buildingName='" + buildingName + '\'' +
                ", status=" + status +
                ", submitTime=" + submitTime +
                ", imagesPath='" + imagesPath + '\'' +
                ", adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", problem='" + problem + '\'' +
                '}';
    }
}