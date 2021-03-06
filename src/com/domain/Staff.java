package com.domain;


/**
 * 2020/7/18 -16:51
 * 员工表，包含员工id，姓名，性别，所属驿站id及管理者id
 **/

public class Staff {
    private int staff_id; //员工编号
    private String staff_name; //员工姓名
    private String staff_sex; //员工性别
    private int station_id; //员工所属驿站编号
    private int manager_id; //员工上级编号

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


    public int getStation_id() {
        return station_id;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    @Override
    public String toString() {

        return "Staff{" +
                "staff_id=" + staff_id +
                ", staff_name='" + staff_name + '\'' +
                ", staff_sex='" + staff_sex + '\'' +
                ", station_id=" + station_id +
                ", manager_id=" + manager_id +
                '}';
    }
}
