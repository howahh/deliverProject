package com.domain;

/**
 * 2020/7/18 -16:43
 * 包裹表
 **/
public class parcel {
    private int parcel_id;
    private int parcel_num;
    private int compy_id;
    private String receiver_name;
    private String sender_name;
    private String receiver_city;
    private String sender_city;
    private String parcel_city;
    private String parcel_zhuangtai;
    private int station_id;

    public int getParcel_id() {
        return parcel_id;
    }

    public void setParcel_id(int parcel_id) {
        this.parcel_id = parcel_id;
    }

    public int getParcel_num() {
        return parcel_num;
    }

    public void setParcel_num(int parcel_num) {
        this.parcel_num = parcel_num;
    }

    public int getCompy_id() {
        return compy_id;
    }

    public void setCompy_id(int compy_id) {
        this.compy_id = compy_id;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getSender_name() {
        return sender_name;
    }

    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public String getReceiver_city() {
        return receiver_city;
    }

    public void setReceiver_city(String receiver_city) {
        this.receiver_city = receiver_city;
    }

    public String getSender_city() {
        return sender_city;
    }

    public void setSender_city(String sender_city) {
        this.sender_city = sender_city;
    }

    public String getParcel_city() {
        return parcel_city;
    }

    public void setParcel_city(String parcel_city) {
        this.parcel_city = parcel_city;
    }

    public String getParcel_zhuangtai() {
        return parcel_zhuangtai;
    }

    public void setParcel_zhuangtai(String parcel_zhuangtai) {
        this.parcel_zhuangtai = parcel_zhuangtai;
    }

    public int getStation_id() {
        return station_id;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    @Override
    public String toString() {
        return "parcel{" +
                "parcel_id=" + parcel_id +
                ", parcel_num=" + parcel_num +
                ", compy_id=" + compy_id +
                ", receiver_name='" + receiver_name + '\'' +
                ", sender_name='" + sender_name + '\'' +
                ", receiver_city='" + receiver_city + '\'' +
                ", sender_city='" + sender_city + '\'' +
                ", parcel_city='" + parcel_city + '\'' +
                ", parcel_zhuangtai='" + parcel_zhuangtai + '\'' +
                ", station_id=" + station_id +
                '}';
    }
}
