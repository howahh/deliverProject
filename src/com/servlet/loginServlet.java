package com.servlet;

import com.dao.impl.UserImpl;
import com.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 2020/7/19 -11:06
 **/
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
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
        boolean flag=false;
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("user");
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
                response.sendRedirect("index.html");
            }
            else
                response.sendRedirect("login.html");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
