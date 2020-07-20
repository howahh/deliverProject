package com.servlet.SrationServlet;
//修改驿站

import com.alibaba.fastjson.JSON;
import com.dao.impl.ManagerImpl;
import com.dao.impl.StationImpl;
import com.domain.Manager;
import com.domain.Station;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/UpdateStation")
public class ServletUpdateStation extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* 允许跨域的主机地址 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 允许跨域的请求方法GET, POST, HEAD 等 */
        response.setHeader("Access-Control-Allow-Methods", "*");
        /* 重新预检验跨域的缓存时间 (s) */
        response.setHeader("Access-Control-Max-Age", "3600");
        /* 允许跨域的请求头 */
        response.setHeader("Access-Control-Allow-Headers", "*");
        /* 是否携带cookie */
        response.setHeader("Access-Control-Allow-Credentials", "true");
//解决中文乱码
        response.setHeader("content-type","text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
//        StationImpl stationImpl=new StationImpl();
 //       int a = request.getParameter("station_id")-"0";

        //获取驿站的id，名字，管理者的名字
        int station_id = Integer.parseInt(request.getParameter("station_id"));
 //       int station_id = Integer.parseInt(station_id2);
        String station_name = request.getParameter("station_name");
        int manager_id = Integer.parseInt(request.getParameter("manager_id"));


        Station station = new Station();
        station.setStation_name(station_name);
        station.setManager_id(manager_id);
        station.setStation_id(station_id);

//        System.out.println(station_name);
//        System.out.println(station_id);
        StationImpl station1 = new StationImpl();
            try {
                station1.update(station);//
            } catch (Exception e) {
                e.printStackTrace();
            }


//        Manager manager = new Manager();
//        manager.setManager_id(manager_id);



    }

}
