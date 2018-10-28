package com.repairsystem.entity;

import javax.persistence.Column;
import javax.persistence.Id;

public class Class {
    /**
     * 实训室ID
     */
    @Id
    @Column(name = "class_id")
    private Integer classId;

    /**
     * 实训室名称
     */
    @Column(name = "class_name")
    private String className;

    /**
     * 所属实训楼
     */
    @Column(name = "building_id")
    private Integer buildingId;

    /**
     * 电脑总数
     */
    @Column(name = "computer_total")
    private Integer computerTotal;

    /**
     * 可用电脑总数
     */
    @Column(name = "computer_enable")
    private Integer computerEnable;

    /**
     * 不可用电脑总数
     */
    @Column(name = "computer_disable")
    private Integer computerDisable;

    /**
     * 获取实训室ID
     *
     * @return class_id - 实训室ID
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * 设置实训室ID
     *
     * @param classId 实训室ID
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * 获取实训室名称
     *
     * @return class_name - 实训室名称
     */
    public String getClassName() {
        return className;
    }

    /**
     * 设置实训室名称
     *
     * @param className 实训室名称
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 获取所属实训楼
     *
     * @return building_id - 所属实训楼
     */
    public Integer getBuildingId() {
        return buildingId;
    }

    /**
     * 设置所属实训楼
     *
     * @param buildingId 所属实训楼
     */
    public void setBuildingId(Integer buildingId) {
        this.buildingId = buildingId;
    }

    /**
     * 获取电脑总数
     *
     * @return computer_total - 电脑总数
     */
    public Integer getComputerTotal() {
        return computerTotal;
    }

    /**
     * 设置电脑总数
     *
     * @param computerTotal 电脑总数
     */
    public void setComputerTotal(Integer computerTotal) {
        this.computerTotal = computerTotal;
    }

    /**
     * 获取可用电脑总数
     *
     * @return computer_enable - 可用电脑总数
     */
    public Integer getComputerEnable() {
        return computerEnable;
    }

    /**
     * 设置可用电脑总数
     *
     * @param computerEnable 可用电脑总数
     */
    public void setComputerEnable(Integer computerEnable) {
        this.computerEnable = computerEnable;
    }

    /**
     * 获取不可用电脑总数
     *
     * @return computer_disable - 不可用电脑总数
     */
    public Integer getComputerDisable() {
        return computerDisable;
    }

    /**
     * 设置不可用电脑总数
     *
     * @param computerDisable 不可用电脑总数
     */
    public void setComputerDisable(Integer computerDisable) {
        this.computerDisable = computerDisable;
    }
}