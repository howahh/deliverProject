package com.dao.impl;

import com.dao.StaffInter;
import com.domain.Staff;
import com.domain.vo.StaffInfo;
import com.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class StaffInterImpl implements StaffInter {

    QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());

    @Override
    public List<Staff> findAll() throws Exception {
        String sql = "select * from staff";
        List<Staff> list = qr.query(sql, new BeanListHandler<Staff>(Staff.class));
        //返回结果通过反射成为一个Javabean的list，Staff是javabean的类型
        return list;
    }


    @Override
    public StaffInfo findOne(int staff_id) throws Exception{
        String sql = "select staff.staff_id,staff.staff_name,staff.staff_sex,station.station_name,manager.manager_name\n" +
                "from staff,station,manager\n" +
                "where staff.station_id=station.station_id\n" +
                "and staff.manager_id=manager.manager_id\n" +
                "and staff.staff_id= "+staff_id;
//        String sql = "select * from staff where staff_name="+"'"+ name +"'";
        //反射成一个Staff类的bean，根据id做查询
        return qr.query(sql, new BeanHandler<StaffInfo>(StaffInfo.class));
    }

    @Override
    public int insert(Staff staff) throws Exception {
        String sql = "insert into staff(staff_id,staff_name,staff_sex,station_id,manager_id) values(?,?,?,?,?)";
        return qr.update(sql,staff.getStaff_id(),staff.getStaff_name(),staff.getStaff_sex(),staff.getStation_id(),staff.getManager_id());
    }

    @Override
    public int update(Staff staff) throws Exception {
        String sql = "update staff set staff_name=?,staff_sex=?,station_id=?,manager_id=? where staff_id=?";
        int a = qr.update(sql,staff.getStaff_name(),staff.getStaff_sex(),staff.getStation_id(),staff.getManager_id(),staff.getStaff_id());
        return 0;
    }

    @Override
    public int delete(int id) throws Exception {
        String sql = "delete from staff where staff_id = ?";
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
        StaffInter dao = new StaffInterImpl();
//        //全部查询
//        List<StaffInfo> list = dao.findAllInfo();
//        System.out.println(list);

//          //按名称寻找
//        StaffInfo staffInfo = new StaffInfo();
//        staffInfo = dao.findOne(1);
//        System.out.println(staffInfo);

//        //增加
//        Staff staff = new Staff();
//        staff.setStaff_id(50);
//        staff.setStaff_name("xzg");
//        staff.setStaff_sex("男");
//        staff.setManager_id(2);
//        staff.setStation_id(3);
//        dao.insert(staff);

//        //删除
//        int id = 50;
//        dao.delete(id);

//        //修改
//        Staff staff = new Staff();
//        staff.setStaff_id(50);
//        staff.setStaff_name("zxw");
//        staff.setStaff_sex("女");
//        staff.setManager_id(6);
//        staff.setStation_id(7);
//        dao.update(staff);

        //vo映射
//        List<StuScore> list = dao.findAllScores();
//        System.out.println(list);

    }


}
