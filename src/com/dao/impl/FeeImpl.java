package com.dao.impl;

import com.dao.FeeInter;
import com.domain.Fee;
import com.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class FeeImpl implements FeeInter {
    QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
    @Override
    public List<Fee> findAll() throws Exception {
        String sql = "select * from fee";
        List<Fee> fees = qr.query(sql, new BeanListHandler<Fee>(Fee.class));
        return fees;
    }
}
