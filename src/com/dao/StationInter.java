package com.dao;

//驿站接口

import com.domain.Station;

import java.util.List;

public interface StationInter {
    //查询所有station
    public List<Station> findAll() throws Exception;
    //根据id寻找station
    public Station findById(int id) throws Exception;
    //删除
    public int delete(int id) throws Exception;
    //增加
    public int insert(Station station) throws Exception;
    //修改
    public int update(Station station) throws Exception;
    //查询驿站包裹

}
