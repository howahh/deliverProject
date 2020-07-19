package com.servlet.SrationServlet;
//修改驿站

import com.dao.impl.ManagerImpl;
import com.domain.Manager;
import com.domain.Station;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        int station_id = Integer.parseInt(request.getParameter("station_id"));
        String station_name = request.getParameter("station_name");
        int manager_id = Integer.parseInt(request.getParameter("manager"));

        Station station = new Station();
        station.setStation_name(station_name);
        station.setManager_id(manager_id);
        station.setStation_id(station_id);

        Manager manager = new Manager();
        manager.setManager_id(manager_id);
        try {
            new ManagerImpl().insert(manager);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
