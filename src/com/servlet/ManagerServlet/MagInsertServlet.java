package com.servlet.ManagerServlet;

import com.dao.impl.ManagerImpl;
import com.domain.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

//url地址：http://localhost:8888/MagInsertServlet
@WebServlet("/MagInsertServlet")
public class MagInsertServlet {

        ManagerImpl magInsert = new ManagerImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("doPost");
        try {
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
            request.setCharacterEncoding("UTF-8");

            //获取前段数据并强制类型转换
            Manager manager = null;
            String magId1 = request.getParameter("manager_id");
            String magName = request.getParameter(("manager_name"));
            String magSex = request.getParameter("manager_sex");
            String staId1 = request.getParameter("station_id");
            int magId = Integer.parseInt("MagId");
            int staId = Integer.parseInt("staId1");

            // 将数据封装在manager对象中
            manager.setManager_id(magId);
            manager.setManager_name(magName);
            manager.setManager_sex(magSex);
            manager.setStation_id(staId);

            //调用dao层显示数据
            magInsert.insert(manager);

        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("doGet");
        try {
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
            request.setCharacterEncoding("UTF-8");

            //获取前段数据并强制类型转换
            Manager manager = null;
            String magId1 = request.getParameter("manager_id");
            String magName = request.getParameter(("manager_name"));
            String magSex = request.getParameter("manager_sex");
            String staId1 = request.getParameter("station_id");
            int magId = Integer.parseInt("MagId");
            int staId = Integer.parseInt("staId1");

            // 将数据封装在manager对象中
            manager.setManager_id(magId);
            manager.setManager_name(magName);
            manager.setManager_sex(magSex);
            manager.setStation_id(staId);

            //调用dao层显示数据
            magInsert.insert(manager);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}