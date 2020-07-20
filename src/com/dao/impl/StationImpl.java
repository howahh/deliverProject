package com.dao.impl;

import com.dao.StationInter;
import com.domain.Station;
import com.domain.vo.Parcel;
import com.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class StationImpl implements StationInter {
    QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());

    @Override
    //包括展示店长表中的店长信息
    public List<Station> findAll() throws Exception {
        String sql = "select station.station_id,station.station_name,station.manager_id,manager.manager_name,manager.manager_sex \n"
                +"from station,manager\n"
                +"where station.manager_id = manager.manager_id";
        List<Station> stations = qr.query(sql, new BeanListHandler<Station>(Station.class));
        return stations;
    }

    @Override
    public Station findById(int station_id) throws Exception {
        String sql = "select station.station_id,station.station_name,manager.manager_name,manager.manager_id\n"
                +"from station,manager\n"
                +"where station.manager_id = manager.manager_id\n"
                +"and station.station_id ="+station_id;
        //反射成一个Station类的bean，根据id做查询
        Station stations = qr.query(sql, new BeanHandler<Station>(Station.class));
        return stations;
    }

    @Override
    //根据id删除数据
    public int delete(int station_id) throws Exception {
        String sql = "delete from station where station_id= ?" ;
        return qr.update(sql,station_id);
    }

    @Override
    public int insert(Station station) throws Exception {
        String sql = "insert into station values(?,?,?)";
        //?中的参数会被qr.update中的参数所替换
        return qr.update(sql, station.getStation_id(), station.getStation_name(),station.getManager_id());
    }

    @Override
    public int update(Station station) throws Exception {
        String sql = "update station set station_name = ?,manager_id = ? where station_id=?";
        return qr.update(sql,station.getStation_name(),station.getManager_id(),station.getStation_id());
    }

     //获得对应驿站的包裹的信息
    public List<Parcel> findStationParcel() throws Exception{
        String sql = "select parcel.parcel_id,parcel.parcel_num,parcel.compy_id,parcel.receiver_name,parcel.sender_name,receiver_city,parcel.sender_city,parcel.parcel_city,parcel.parcel_zhuangtai,parcel.station_id\n" +
                "from parcel,station\n" +
                "where station.station_id=parcel.station_id" ;
        List<Parcel> list= qr.query(sql,new BeanListHandler<Parcel>(Parcel.class));
        return list;
    }

//    public static void main(String[] args) throws Exception {
//
//        StationImpl stationImpl = new StationImpl();
//        Station station = new Station();
//        station.setManager_id(11);
//        station.setStation_name("77");
//        station.setStation_id(9);
//        stationImpl.update(station);
//
//    }

}
