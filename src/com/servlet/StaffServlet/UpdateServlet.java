package com.servlet.StaffServlet;

import com.dao.StaffInter;
import com.dao.impl.StaffInterImpl;
import com.domain.Staff;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/StaffUpdateServlet")
public class UpdateServlet extends HttpServlet {
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


        Staff staff= new Staff();
        //从前端获取输入的数据
        String sid = request.getParameter("staff_id");
        int id = Integer.parseInt(sid);
        String name = request.getParameter("staff_name");
        String sex = request.getParameter("staff_sex");
        String sid2 = request.getParameter("station_id");
        int s_id = Integer.parseInt(sid2);
        String sid3= request.getParameter("manager_id");
        int m_id = Integer.parseInt(sid3);

        //将数据封装在staff对象中
        staff.setStaff_id(id);
        staff.setStaff_name(name);
        staff.setStaff_sex(sex);
        staff.setStation_id(s_id);
        staff.setManager_id(m_id);

        //更新数据
        try {
            staffInter.update(staff);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        response.sendRedirect("index.html");
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


        Staff staff= new Staff();
        //从前端获取输入的数据
        String sid = request.getParameter("staff_id");
        int id = Integer.parseInt(sid);
        String name = request.getParameter("staff_name");
        String sex = request.getParameter("staff_sex");
        String sid2 = request.getParameter("station_id");
        int s_id = Integer.parseInt(sid2);
        String sid3= request.getParameter("manager_id");
        int m_id = Integer.parseInt(sid3);

        //将数据封装在staff对象中
        staff.setStaff_id(id);
        staff.setStaff_name(name);
        staff.setStaff_sex(sex);
        staff.setStation_id(s_id);
        staff.setManager_id(m_id);

        //更新数据
        try {
            staffInter.update(staff);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        response.sendRedirect("index.html");
    }
}
