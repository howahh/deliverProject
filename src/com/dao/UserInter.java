package com.dao;

import com.domain.Example;
import com.domain.User;

import java.util.List;

/**
 * 2020/7/19 -10:35
 **/
public interface UserInter {
    //选取全部用户
    public List<User> findAllUser() throws Exception;
    //按照id选取用户
    public User findByid(int user_id) throws Exception;
    //增加
    public int insert(User user)throws Exception;   //无需要的返回，以一个对象为参数
    //删除
    public int delete(User user)throws Exception;
    //更改密码
    public int updatePsw(User user)throws Exception;
}
