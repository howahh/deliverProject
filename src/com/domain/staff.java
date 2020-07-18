package com.domain;

/**
 * 2020/7/18 -16:51
 * 员工表，包含员工id，姓名，性别，所属驿站id及管理者id
 **/
public class staff {
    private int staf_id;
    private String staff_name;
    private int station_id;
    private int manager_id;

    public int getStaf_id() {
        return staf_id;
    }

    public void setStaf_id(int staf_id) {
        this.staf_id = staf_id;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
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
        return "staff{" +
                "staf_id=" + staf_id +
                ", staff_name='" + staff_name + '\'' +
                ", station_id=" + station_id +
                ", manager_id=" + manager_id +
                '}';
    }
}
