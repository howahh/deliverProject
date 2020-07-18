package com.dao.singleinter;

import com.domain.Company;

import java.util.List;

/**
 * 2020/7/18 -17:40
 **/
public interface CompanyInter {
    //查找全部
    public List<Company> findAll() throws Exception;
    //通过id查找公司
    public Company findOne(int id) throws Exception;
    //对于快递公司没有增加以及删除功能

}
