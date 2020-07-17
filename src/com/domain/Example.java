package com.domain;

/**
 * 2020/7/17 -20:52
 **/
public class Example {
    private int id;
    private String exam1;
    private String exam2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExam1() {
        return exam1;
    }

    public void setExam1(String exam1) {
        this.exam1 = exam1;
    }

    public String getExam2() {
        return exam2;
    }

    public void setExam2(String exam2) {
        this.exam2 = exam2;
    }

    @Override
    public String toString() {
        return "Example{" +
                "id=" + id +
                ", exam1='" + exam1 + '\'' +
                ", exam2='" + exam2 + '\'' +
                '}';
    }
}
