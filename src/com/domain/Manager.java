package com.domain;

/**
 * 2020/7/18 -16:36
 * 驿站管理人员表
 * 管理员id：manager_id，名称，性别，管理的驿站id
 **/
public class Manager {
    private int manager_id;
    private String manager_name;
    private String  manager_sex;
    private int station_id;

    public int getManager_id() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id = manager_id;
    }

    public String getManager_name() {
        return manager_name;
    }

    public void setManager_name(String manager_name) {
        this.manager_name = manager_name;
    }

    public String getManager_sex() {
        return manager_sex;
    }

    public void setManager_sex(String manager_sex) {
        this.manager_sex = manager_sex;
    }

    public int getStation_id() {
        return station_id;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    @Override
    public String toString() {
        return "manager{" +
                "manager_id=" + manager_id +
                ", manager_name='" + manager_name + '\'' +
                ", manager_sex='" + manager_sex + '\'' +
                ", station_id=" + station_id +
                '}';
    }
}
