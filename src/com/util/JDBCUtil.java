package com.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 2020/7/17 -20:53
 * 数据池，控制数据库连接与关闭
 **/

public class JDBCUtil {


    private static ComboPooledDataSource cpds = new ComboPooledDataSource();//c3p0提供数据源,该对象创建时分配资源，创建了分配池
    public static DataSource getDataSource(){
        return cpds;
    }//获取数据源


    public static Connection getConn() throws Exception {
        //从连接池中获取连接
        return cpds.getConnection();
    }

    //关闭连接，只是放回连接池
    public void closeConn(Connection conn) throws Exception {
        conn.close();
    }
}

