package com.servlet.StaffServlet;

import com.alibaba.fastjson.JSON;
import com.dao.StaffInter;
import com.dao.impl.StaffInterImpl;
import com.domain.Example;
import com.domain.Staff;
import com.domain.vo.StaffInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/StaffFindOneServlet")
public class FindOneServlet extends HttpServlet {
    private StaffInter staffInter = new StaffInterImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 跨域，与前端进行连接
         */
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

            StaffInfo staff = new StaffInfo();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");

            String id = request.getParameter("staff_id");//获取页面输入的姓名信息
            int staff_id = Integer.parseInt(id);
            staff= staffInter.findOne(staff_id);

            String jsonStr = JSON.toJSONString(staff);//转换为json格式
            PrintWriter out = response.getWriter(); //响应对象输出流
            out.print("["+jsonStr+"]");
            out.flush();
            out.close();
            //通过流返回客户端
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 跨域，与前端进行连接
         */
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

            StaffInfo staff = null;
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            String id = request.getParameter("staff_id");
            int staff_id = Integer.parseInt(id);
        try {
            staff= staffInter.findOne(staff_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String jsonStr = JSON.toJSONString(staff);//转换为json格式
            PrintWriter out = response.getWriter(); //响应对象输出流
            out.print("["+jsonStr+"]");
            out.flush();
            out.close();
            //通过流返回客户端
    }
}
