package com.dao.impl.singleimpl;

import com.dao.singleinter.CompanyInter;
import com.domain.Company;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * 2020/7/18 -17:46
 **/
public class CompanyImpl implements CompanyInter {
    QueryRunner qr = new QueryRunner();
    @Override
    public List<Company> findAll() throws Exception {
        String sql="select * from company";
        List<Company> list=qr.query(sql,new BeanListHandler<Company>(Company.class));
        return list;
    }

    @Override
    public Company findOne(int id) throws Exception {
        String sql = "select * from company where id="+id;
        Company company = qr.query(sql, new BeanHandler<Company>(Company.class));
        return company;
    }
}
