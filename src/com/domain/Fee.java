package com.domain;

/**
 * 2020/7/18 -16:33
 **/
public class Fee {
    private int compy_id;
    private String compy_name;
    private int inpro_first;
    private int inpro_next;
    private int outpro_first;
    private int outpro_next;
    private int international;

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

    public int getInpro_first() {
        return inpro_first;
    }

    public void setInpro_first(int inpro_first) {
        this.inpro_first = inpro_first;
    }

    public int getInpro_next() {
        return inpro_next;
    }

    public void setInpro_next(int inpro_next) {
        this.inpro_next = inpro_next;
    }

    public int getOutpro_first() {
        return outpro_first;
    }

    public void setOutpro_first(int outpro_first) {
        this.outpro_first = outpro_first;
    }

    public int getOutpro_next() {
        return outpro_next;
    }

    public void setOutpro_next(int outpro_next) {
        this.outpro_next = outpro_next;
    }

    public int getInternational() {
        return international;
    }

    public void setInternational(int international) {
        this.international = international;
    }

    @Override
    public String toString() {
        return "fee{" +
                "compy_id=" + compy_id +
                ", compy_name='" + compy_name + '\'' +
                ", inpro_first=" + inpro_first +
                ", inpro_next=" + inpro_next +
                ", outpro_first=" + outpro_first +
                ", outpro_next=" + outpro_next +
                ", international=" + international +
                '}';
    }
}
