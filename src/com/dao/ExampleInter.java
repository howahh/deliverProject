package com.dao;

import com.domain.Example;

import java.util.List;

/**
 * 2020/7/17 -20:51
 **/
public interface ExampleInter {
    /**
     * 基础单表增删查改接口
     * @return
     * @throws Exception
     */
    //全查，用list储存dept所有对象，返回
    public List<Example> findAll() throws Exception;    //不需要参数
    //查特定,存储一个dept,返回一个dept
    public Example findOne(int id) throws Exception;   //以deptnum为查询基础
    //增加
    public int insert(Example example)throws Exception;   //无需要的返回，以一个对象为参数
    //删除
    public int delete(Example example)throws Exception;
    //改
    public int update(Example example)throws Exception;


}
