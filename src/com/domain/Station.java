package com.domain;

/**
 * 2020/7/18 -16:54
 * 驿站表，包括驿站id，地址
 **/
public class Station {
    private int station_id;
    private String station_name;

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
        return "station{" +
                "station_id=" + station_id +
                ", station_name='" + station_name + '\'' +
                '}';
    }
}
