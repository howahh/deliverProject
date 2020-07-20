package com.servlet;

import com.alibaba.fastjson.JSON;
import com.dao.impl.UserImpl;
import com.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 2020/7/19 -11:06
 **/
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    public static User userinfo;
    public static boolean flag=false;
    UserImpl user = new UserImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        User users;

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("id");
        String password = request.getParameter("password");
        System.out.println(name+" : "+password);
        try {
            List<User> list1 = user.findAllUser();
            for(int i=0;i<list1.size();i++){
                users = list1.get(i);
                if(users.getUser_name().equals(name)&&users.getUser_password().equals(password)){
                    userinfo=users;
                    flag =true;
                    break;
                }
            }
            System.out.println(flag);
            if (flag==true){
                /**
                 * 返回字符串通过字符串在前端定位是index还是login
                 */
//                response.sendRedirect("index.html");
                String index="index.html";
                String jsonStr = JSON.toJSONString(index);//转换为json格式
                PrintWriter out = response.getWriter(); //响应对象输出流
//                System.out.println(jsonStr.getClass().getTypeName());
                out.print(jsonStr);
                out.flush();
                out.close();
            }
            else{
//                response.sendRedirect("login.html");

                String login="login.html";
                String jsonStr = JSON.toJSONString(login);//转换为json格式
                PrintWriter out = response.getWriter(); //响应对象输出流
                out.print(jsonStr);
                out.flush();
                out.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

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

        User users;
        boolean flag=false;
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String name = request.getParameter("id");
        String password = request.getParameter("password");
        System.out.println(name+" : "+password);
        try {
            List<User> list = user.findAllUser();
            for(int i=0;i<list.size();i++){
                users = list.get(i);
                if(users.getUser_name().equals(name)&&users.getUser_password().equals(password)){
                    flag =true;
                    break;
                }
            }
            System.out.println(flag);
            if (flag==true){
                /**
                 * 返回字符串通过字符串在前端定位是index还是login
                 */
//                response.sendRedirect("index.html");
                String index="index.html";
                String jsonStr = JSON.toJSONString(index);//转换为json格式
                System.out.println(jsonStr);
                PrintWriter out = response.getWriter(); //响应对象输出流
                out.print(jsonStr);
                out.flush();
                out.close();
            }
            else{
//                response.sendRedirect("login.html");

                String login="login.html";
                String jsonStr = JSON.toJSONString(login);//转换为json格式
                PrintWriter out = response.getWriter(); //响应对象输出流
                out.print(jsonStr);
                out.flush();
                out.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
