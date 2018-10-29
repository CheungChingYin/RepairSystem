package com.repairsystem.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

public class Orders {
    /**
     * 工单ID
     */
    @Id
    @Column(name = "order_id")
    private Integer orderId;

    /**
     * 电脑序号
     */
    @Column(name = "computer_number")
    private Integer computerNumber;

    /**
     * 所属教室ID
     */
    @Column(name = "class_id")
    private Integer classId;

    /**
     * 所属实训楼ID
     */
    @Column(name = "building_id")
    private Integer buildingId;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 提交时间
     */
    @Column(name = "submit_time")
    private Date submitTime;

    /**
     * 完成时间
     */
    @Column(name = "complete_time")
    private Date completeTime;

    /**
     * 故障图片上传
     */
    @Column(name = "images_path")
    private String imagesPath;

    /**
     * 接手管理员ID
     */
    @Column(name = "admin_id")
    private Integer adminId;

    /**
     * 报修人名称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 报修人电话
     */
    @Column(name = "user_phone")
    private String userPhone;

    /**
     * 报修人邮箱
     */
    @Column(name = "user_email")
    private String userEmail;

    /**
     * 工单问题
     */
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
     * 获取完成时间
     *
     * @return complete_time - 完成时间
     */
    public Date getCompleteTime() {
        return completeTime;
    }

    /**
     * 设置完成时间
     *
     * @param completeTime 完成时间
     */
    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
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
}