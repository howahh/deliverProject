package com.servlet.ManagerServlet;

import com.alibaba.fastjson.JSON;
import com.dao.impl.ManagerImpl;
import com.domain.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;


//url地址：http://localhost:8888/MagFindAllServlet
@WebServlet("/MagFindAllServlet")
public class MagFindAllServlet extends HttpServlet {

    private ManagerImpl magFindAll = new ManagerImpl();


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
            response.setContentType("text/json; charset=utf-8");

            //调用dao层获得信息
            List<Manager> list = magFindAll.findall();
            String jsonStr = JSON.toJSONString(list);

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
            response.setContentType("text/json; charset=utf-8");

            //调用dao层获得信息
            List<Manager> list = magFindAll.findall();
            String jsonStr = JSON.toJSONString(list);
            //
            // 把JSON数据作为流（数据流）返回给界面
            PrintWriter out = response.getWriter();
            out.print(jsonStr);
            out.flush();
            out.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
