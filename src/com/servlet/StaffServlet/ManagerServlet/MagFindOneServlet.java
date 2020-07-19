package com.servlet.StaffServlet.ManagerServlet;

import com.alibaba.fastjson.JSON;
import com.dao.ManagerInter;
import com.dao.impl.ManagerImpl;
import com.domain.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;



//url地址：http://localhost:8888/MagFindOneServlet
@WebServlet("/MagFindOneServlet")
public class MagFindOneServlet {

    private ManagerImpl magFindOne = new ManagerImpl();

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
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");

            //获取前端数据
            String mag_name = request.getParameter("manager_name");

            //调用dao层方法
            Manager magOne = magFindOne.findByName(mag_name);
            //返回数据
            String jsonStr = JSON.toJSONString(magOne);
            PrintWriter out = response.getWriter();
            out.print(jsonStr);
            out.flush();
            out.close();


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
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            //获取前端数据
            String mag_name = request.getParameter("manager_name");

            //调用dao层方法
            Manager magOne = magFindOne.findByName(mag_name);
            //返回数据
            String jsonStr = JSON.toJSONString(magOne);
            PrintWriter out = response.getWriter();
            out.print(jsonStr);
            out.flush();
            out.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
