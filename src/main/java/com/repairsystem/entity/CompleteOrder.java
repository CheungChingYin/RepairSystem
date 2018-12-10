package com.repairsystem.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@ApiModel(value = "完成工单对象",description = "这是完成工单对象")
@Table(name = "complete_order")
public class CompleteOrder {
    /**
     * 完成工单ID
     */
    @Id
    @Column(name = "order_id")
    @ApiModelProperty(value = "完成工单ID",name = "orderId")
    private Integer orderId;

    /**
     * 管理员ID
     */
    @Column(name = "admin_id")
    @ApiModelProperty(value = "管理员ID",name = "adminName",example = "1",required = true)
    private Integer adminId;

    /**
     * 管理员姓名
     */
    @ApiModelProperty(hidden = true)
    private String adminName;

    /**
     * 完成时间
     */
    @Column(name = "complete_time")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(hidden = true)
    private Date completeTime;

    /**
     * 故障图片
     */
    @Column(name = "image_path")
    @ApiModelProperty(value = "上传图片路径")
    private String imagePath;

    /**
     * 工单问题
     */
    @ApiModelProperty(value = "工单问题",name = "problem",example = "电脑出现问题",required = true)
    private String problem;

    /**
     * 记录
     */
    @ApiModelProperty(value = "解决问题记录",name = "remark",example = "电脑解决问题")
    private String remark;

    /**
     * 所属教室ID
     */
    @Column(name = "class_id")
    @ApiModelProperty(value = "实训室ID",name = "classId",example = "1",required = true)
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

    @Column(name = "computer_number")
    @ApiModelProperty(value = "出现问题的电脑编号", name = "computerNumber", example = "1", required = true)
    private Integer computerNumber;

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

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
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
                ", classId=" + classId +
                ", className='" + className + '\'' +
                ", buildingId=" + buildingId +
                ", buildingName='" + buildingName + '\'' +
                ", computerNumber=" + computerNumber +
                '}';
    }
}