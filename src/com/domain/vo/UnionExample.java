package com.domain.vo;

/**
 * 2020/7/17 -20:52
 **/
public class UnionExample {
    /**
     * 多表联查属性
     */
    private String ename;
    private String dname;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "WorkLoc{" +
                "ename='" + ename + '\'' +
                ", dname='" + dname + '\'' +
                '}';
    }
}
