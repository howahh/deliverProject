package com.domain.vo;

import java.util.List;

public class MagStation {
    private int manager_id;
    private String manager_name;
    private int station_id;
    private String station_name;

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

    public int getStation_id() {
        return station_id;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    @Override
    public String toString() {
        return "MagStation{" +
                "manager_id=" + manager_id +
                ", manager_name='" + manager_name + '\'' +
                ", station_id=" + station_id +
                ", station_name='" + station_name + '\'' +
                '}';
    }
}
