package com.dao.impl;

import com.dao.UserInter;
import com.domain.User;
import com.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * 2020/7/19 -10:37
 **/
public class UserImpl implements UserInter {
    QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
    @Override

    public List<User> findAllUser() throws Exception {
        String sql = "select * from user";
        List<User> list = qr.query(sql,new BeanListHandler<User>(User.class));
        return list;
    }

    @Override
    public User findByid(int user_id) throws Exception {
        String sql = "selct * from user where user_id="+user_id;
        User user = qr.query(sql,new BeanHandler<User>(User.class));
        return user;
    }

    @Override
    public int insert(User user) throws Exception {
        String sql = "insert into user values(?,?,?,?)";
        int a = qr.update(sql,user.getUser_id(),user.getUser_name(),user.getUser_password(),user.getUser_sex());
        return a;
    }

    @Override
    public int delete(User user) throws Exception {
        String sql = "delete from user where user_id= ?";
        int a = qr.update(sql,user.getUser_id());
        return a;
    }

    @Override
    public int updatePsw(User user) throws Exception {
        String sql = "update user set user_password= ? where id=?;";
        int a = qr.update(sql,user.getUser_password(),user.getUser_id());
        return a;
    }
}
