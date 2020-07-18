package com.domain;

/**
 * 2020/7/18 -16:31
 * 各家快递公司表
 * 包括compy_id和名称compy_name
 **/
public class Company {
    private int compy_id;
    private String compy_name;
    public int getCompy_id() {
        return compy_id;
    }

    public void setCompy_id(int compy_id) {
        this.compy_id = compy_id;
    }

    public String getCompy_name() {
        return compy_name;
    }

    public void setCompy_name(String compy_name) {
        this.compy_name = compy_name;
    }

    @Override
    public String toString() {
        return "company{" +
                "compy_id=" + compy_id +
                ", compy_name='" + compy_name + '\'' +
                '}';
    }
}
