package com.repairsystem.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "complete_order")
public class CompleteOrder {
    /**
     * 完成工单ID
     */
    @Id
    @Column(name = "order_id")
    private Integer orderId;

    /**
     * 管理员ID
     */
    @Column(name = "admin_id")
    private Integer adminId;

    /**
     * 管理员姓名
     */
    private String adminName;

    /**
     * 完成时间
     */
    @Column(name = "complete_time")
    private Date completeTime;

    /**
     * 故障图片
     */
    @Column(name = "image_path")
    private String imagePath;

    /**
     * 工单问题
     */
    private String problem;

    /**
     * 记录
     */
    private String remark;

    /**
     * 获取完成工单ID
     *
     * @return order_id - 完成工单ID
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 设置完成工单ID
     *
     * @param orderId 完成工单ID
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

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
     * 获取管理员名称
     * @return
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * 设置管理员名称
     * @param adminName
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
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
     * 获取故障图片
     *
     * @return image_path - 故障图片
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * 设置故障图片
     *
     * @param imagePath 故障图片
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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

    /**
     * 获取记录
     *
     * @return remark - 记录
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置记录
     *
     * @param remark 记录
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "CompleteOrder{" +
                "orderId=" + orderId +
                ", adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", completeTime=" + completeTime +
                ", imagePath='" + imagePath + '\'' +
                ", problem='" + problem + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}