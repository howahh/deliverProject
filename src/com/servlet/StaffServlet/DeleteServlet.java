package com.servlet.StaffServlet;

import com.dao.StaffInter;
import com.dao.impl.StaffInterImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StaffDeleteServlet")
public class DeleteServlet extends HttpServlet {
    private StaffInter staffInter = new StaffInterImpl();
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
        request.setCharacterEncoding("UTF-8");


        String sid = request.getParameter("staff_id");//通过ID检索并删除对应项
        int id = Integer.parseInt(sid);
        try {
            staffInter.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
       // response.sendRedirect("/FindAllServlet");
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
        request.setCharacterEncoding("UTF-8");


        String sid = request.getParameter("staff_id");//通过ID检索并删除对应项
        int id = Integer.parseInt(sid);
        try {
            staffInter.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // response.sendRedirect("/FindAllServlet");
    }
}
