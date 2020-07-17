package com.dao.impl;

import com.dao.ExampleInter;
import com.domain.Example;
import com.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * 2020/7/17 -20:51
 **/
public class ExampleImpl implements ExampleInter {
    /**
     * 创建queryrunner，用于执行说起来对象，直接和数据源绑定了
     */
    QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());

    public List<Example> findAll() throws Exception {
        String sql = "select * from example";
        List<Example> Examples = qr.query(sql, new BeanListHandler<Example>(Example.class));
        //返回结果通过反射成为一个Javabean的list，Example是javabean
        return Examples;
    }

    @Override
    public Example findOne(int id) throws Exception {
        String sql = "select * from example where id=" + id;
        //反射成一个Example类的bean，根据id做查询
        Example Example = qr.query(sql, new BeanHandler<Example>(Example.class));
        return Example;
    }

    @Override
    public int insert(Example example) throws Exception {
        String sql = "insert into example values(?,?,?)";
        //?中的参数会被qr.update中的参数所替换
        int a = qr.update(sql, example.getId(), example.getExam1(), example.getExam2());
        return a;
    }

    @Override
    public int delete(Example example) throws Exception {
        String sql = "delete from example where id= ?";
        int a = qr.update(sql, example.getId());
        return a;
    }

    @Override
    public int update(Example example) throws Exception {
        String sql = "update example set id?,exam1?,exam2=?";
        int a = qr.update(sql, example.getId(), example.getExam1(), example.getExam2());
        return 0;
    }

    /**
     *
     * @return  多表查询
     * @throws Exception
     */
//    @Override
//    public List<WorkLoc> findName() throws Exception {
//        String sql = "select ename,dname\n" +
//                "from emp,Example\n" +
//                "where emp.Exampleno=Example.Exampleno\n" +
//                "and emp.job='CLERK'";
//        List<WorkLoc> list = qr.query(sql, new BeanListHandler<WorkLoc>(WorkLoc.class));
//        return list;
//    }
}
