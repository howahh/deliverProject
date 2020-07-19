package com.servlet.StaffServlet.ManagerServlet;

import com.alibaba.fastjson.JSON;
import com.dao.impl.ManagerImpl;
import com.domain.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


//url地址：http://localhost:8888/MagDeleteServlet
@WebServlet("/MagDeleteServlet")
public class MagDeleteServlet {

    ManagerImpl magDelete = new ManagerImpl();

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

            Manager manager = null;
            //获取前端数据并且强制类型转换
            int id = Integer.parseInt(request.getParameter("manager_id"));
            //调用dao层删除数据
            int magId = magDelete.delete(id);


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

            Manager manager = null;
            //获取前端数据并且强制类型转换
            int id = Integer.parseInt(request.getParameter("manager_id"));
            //调用dao层删除数据
            int magId = magDelete.delete(id);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



}
