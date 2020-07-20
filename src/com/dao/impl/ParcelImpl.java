package com.dao.impl;

import com.dao.ParcelInter;
import com.dao.StaffInter;
import com.domain.Parcel;
import com.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 2020/7/19 -15:24
 **/
public class ParcelImpl implements ParcelInter {
    QueryRunner qr= new QueryRunner(JDBCUtil.getDataSource());

    /**
     * 返回所有
     * @return
     * @throws Exception
     */
    @Override
    public List<Parcel> findAll() throws Exception {
        String sql = "select * from parcel";
        List<Parcel> list = qr.query(sql,new BeanListHandler<Parcel>(Parcel.class));
        return list;
    }

    /**
     * 通过单号查询订单信息
     * @param parcel_bum
     * @return
     * @throws Exception
     */
    @Override
    public Parcel findByNum(int parcel_bum) throws Exception {
        String sql = "select * from parcel where parcel_num="+parcel_bum;
        Parcel parcel = qr.query(sql,new BeanHandler<Parcel>(Parcel.class));
        return parcel;
    }

    /**
     * 新增数据
     * @param parcel
     * @return
     * @throws Exception
     */
    @Override
    public int insert(Parcel parcel) throws Exception {
        String sql = "insert into parcel values(?,?,?,?,?,?,?,?,?,?)";
        int a= qr.update(sql,parcel.getParcel_id(),parcel.getParcel_num(),parcel.getCompy_id(),parcel.getReceiver_name(),parcel.getSender_name(),parcel.getReceiver_city(),parcel.getSender_city(),parcel.getParcel_city(),parcel.getParcel_zhuangtai(),parcel.getStation_id());
        return a;
    }

    /**
     * 以id来删除，徐根据前端做改动
     * @param parcel
     * @return
     * @throws Exception
     */
    @Override
    public int delete(Parcel parcel) throws Exception {
        String sql = "delete from parcel where parcel_id= ?";
        int a = qr.update(sql,parcel.getParcel_id());
        return a;
    }
    //编辑包裹信息
    @Override
    public int update(Parcel parcel) throws Exception {
        String sql = "update parcel set parcel_id=?,parcel_num=?,compy_id=?,receiver_name=?,sender_name=?,receiver_city=?,sender_city=?,parcel_city=?,parcel_zhuangtai=?,station_id=? where parcel_id=?";
        int a= qr.update(sql,parcel.getParcel_id(),parcel.getParcel_num(),parcel.getCompy_id(),parcel.getReceiver_name(),parcel.getSender_name(),parcel.getReceiver_city(),parcel.getSender_city(),parcel.getParcel_city(),parcel.getParcel_zhuangtai(),parcel.getStation_id(),parcel.getParcel_id());
        return a;
    }
}
