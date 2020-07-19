package com.domain.vo;

public class StaffInfo {
    private int staff_id; //员工编号
    private String staff_name; //员工姓名
    private String staff_sex; //员工性别
    private String station_name; //员工所在驿站
    private String manager_name; //员工上级

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getStaff_sex() {
        return staff_sex;
    }

    public void setStaff_sex(String staff_sex) {
        this.staff_sex = staff_sex;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    @Override
    public String toString() {
        return "StaffInfo{" +
                "staff_id=" + staff_id +
                ", staff_name='" + staff_name + '\'' +
                ", staff_sex='" + staff_sex + '\'' +
                ", station_name='" + station_name + '\'' +
                ", manager_name='" + manager_name + '\'' +
                '}';
    }
}
