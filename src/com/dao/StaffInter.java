package com.dao;

import com.domain.Staff;
import com.domain.vo.StaffInfo;

import java.util.List;

public interface StaffInter {
    /*
     查询Staff表的所有数据
     Staff的list，代表多个员工对象————是数据库中员工表的多行
      */
    public List<Staff> findAll() throws Exception;

    public StaffInfo findOne(int id) throws Exception;

    /*
    把内存中的数据放到数据库中
    内存中的一个对象————数据库的一行
    dao是数据库操作类，真正的操作在方法中
     */
    public int insert(Staff staff) throws Exception;

    public int update(Staff staff) throws Exception;

    public int delete(int id) throws Exception; //根据ID做删除

    public List<StaffInfo> findAllInfo() throws Exception;
}
