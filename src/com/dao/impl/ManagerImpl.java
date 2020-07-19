package com.dao.impl;

import com.dao.ManagerInter;
import com.domain.Manager;
import com.domain.vo.MagStation;
import com.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ManagerImpl implements ManagerInter {

   QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());



    @Override
    public List<Manager> findAll() throws SQLException {
        String sql = "select * from manager";
        List<Manager> list = qr.query(sql,new BeanListHandler<Manager>(Manager.class));

        return list;
    }

    @Override
    public Manager findById(int manager_id) throws SQLException {

        String sql = "select * from manager where manager_id = "+ manager_id;

        return qr.query(sql,new BeanHandler<Manager>(Manager.class));
    }

    @Override
    public int insert(Manager manager) throws SQLException {
        String sql = "insert into manager(manager_id,manager_name,manager_sex,station_id) values(?,?,?,?)";


        return qr.update(sql,manager.getManager_id(),manager.getManager_name(),manager.getManager_sex(),manager.getStation_id());
    }

    @Override
    public int update(Manager manager) throws SQLException {
        String sql ="update manager set manager_name = ?, manager_sex = ?,station_id = ? where manager_id = ?";

        return qr.update(sql,manager.getManager_name(),manager.getStation_id(),manager.getStation_id());
    }

    @Override
    public int delete(int manager_id) throws SQLException {
        String sql ="delete from manager where manager_id =?";


        return qr.update(sql, manager_id);
    }

    @Override
    public List<MagStation> findMagStation() throws SQLException {
        String sql = "select manager.manager_id,manager_name,station.station_id,station_name\n" +
                "from manager,station\n" +
                "where manager.manager_id = station.manager_id\n" +
                "order by manager.manager_id;";
        return qr.query(sql,new BeanListHandler<MagStation>(MagStation.class));
    }


    public static void main(String[] args) throws SQLException {
         ManagerInter dao = new ManagerImpl();
        List<Manager> list = dao.findAll();
        System.out.println(list);


//        Manager manager = new Manager();
//        manager.setManager_id(7);
//        manager.setManager_name("万兴");
//        manager.setManager_sex("男");
//        manager.setStation_id(1);
//        dao.insert(manager);



//        List<MagStation> list = dao.findMagStation();
//        System.out.println(list);
//
//
//        JSON.parse("");
//        String jsonStr = JSON.toJSONString(list);
//        System.out.println(jsonStr);







    }







}
