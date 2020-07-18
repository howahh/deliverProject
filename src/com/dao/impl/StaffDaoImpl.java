package com.dao.impl;

import com.dao.StaffDao;
import com.domain.Example;
import com.domain.Staff;
import com.domain.vo.StaffInfo;
import com.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class StaffDaoImpl implements StaffDao {

    QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());

    @Override
    public List<Staff> findAll() throws Exception {
        String sql = "select * from staff";
        List<Staff> list = qr.query(sql, new BeanListHandler<Staff>(Staff.class));
        //返回结果通过反射成为一个Javabean的list，Staff是javabean
        return list;
    }

    @Override
    public Staff findOne(int id) throws Exception{
        String sql = "select * from staff where id=" + id;
        //反射成一个Staff类的bean，根据id做查询
        Staff staff = qr.query(sql, new BeanHandler<Staff>(Staff.class));
        return staff;
    }

    @Override
    public int insert(Staff staff) throws Exception {
        String sql = "insert into stu(staff_id,staff_name,staff_sex,station_id,manager_id) values(?,?,?,?,?)";
        return qr.update(sql,staff.getStaff_id(),staff.getStaff_name(),staff.getStaff_sex(),staff.getStation_id(),staff.getManager_id());
    }

    @Override
    public int update(Staff staff) throws Exception {
        String sql = "update staff set staff_name = ?,staff_sex=?,station_id=?,manager_id=?, where staff_id=?";
        return qr.update(sql,staff.getStaff_name(),staff.getStaff_sex(),staff.getStation_id(),staff.getManager_id(),staff.getStaff_id());
    }

    @Override
    public int delete(int id) throws Exception {
        String sql = "delete from stu where staff_id = ?";
        return qr.update(sql,id);
    }

    @Override
    public List<StaffInfo> findAllInfo() throws Exception {
        String sql = "select staff.staff_id,staff.staff_name,staff.staff_sex,station.station_name,manager.manager_name\n" +
                "from staff,station,manager\n" +
                "where staff.station_id=station.station_id\n" +
                "and staff.manager_id=manager.manager_id\n" +
                "ORDER BY staff.staff_id;";
        return qr.query(sql, new BeanListHandler<StaffInfo>(StaffInfo.class));
    }

    public static void main(String[] args) throws Exception {
        StaffDao dao = new StaffDaoImpl();
        //全部查询
        List<StaffInfo> list = dao.findAllInfo();
        System.out.println(list);
    }
}
