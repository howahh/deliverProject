package com.dao;

import com.domain.Parcel;

import java.util.List;

/**
 * 2020/7/19 -15:15
 **/
public interface ParcelInter {
    //获取包裹全部信息
    public List<Parcel> findAll() throws Exception;
    //通过parcel_num查询该包裹信息
    public Parcel findByNum(int parcel_bum) throws Exception;
    //增加包裹
    public int insert(Parcel parcel) throws Exception;
    //删除包裹信息
    public int delete(Parcel parcel)throws  Exception;
    //更新包裹信息
    public int update(Parcel parcel)throws Exception;
}
