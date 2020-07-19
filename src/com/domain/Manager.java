package com.domain;

public class Manager {
    private int manager_id;
    private  String manager_name;
    private  String manager_sex;
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
        return "Manager{" +
                "mag_id=" + manager_id +
                ", mag_name='" + manager_name + '\'' +
                ", mag_sex='" + manager_sex + '\'' +
                ", stat_id=" + station_id +
                '}';
    }
}
