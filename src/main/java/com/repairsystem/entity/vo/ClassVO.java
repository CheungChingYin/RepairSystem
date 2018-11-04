package com.repairsystem.entity.vo;

/**
 * @author CheungChingYin
 * @date 2018/11/2
 * @time 21:30
 */
public class ClassVO {

    private Integer classId;
    private String className;
    private String buildingName;
    private Integer computerTotal;
    private Integer computerEnable;
    private Integer computerDisable;

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

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public Integer getComputerTotal() {
        return computerTotal;
    }

    public void setComputerTotal(Integer computerTotal) {
        this.computerTotal = computerTotal;
    }

    public Integer getComputerEnable() {
        return computerEnable;
    }

    public void setComputerEnable(Integer computerEnable) {
        this.computerEnable = computerEnable;
    }

    public Integer getComputerDisable() {
        return computerDisable;
    }

    public void setComputerDisable(Integer computerDisable) {
        this.computerDisable = computerDisable;
    }

    @Override
    public String toString() {
        return "ClassVO{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", buildingName='" + buildingName + '\'' +
                ", computerTotal=" + computerTotal +
                ", computerEnable=" + computerEnable +
                ", computerDisable=" + computerDisable +
                '}';
    }
}
