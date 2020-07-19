package com.servlet.StaffServlet;

import com.alibaba.fastjson.JSON;
import com.dao.StaffInter;
import com.dao.impl.StaffInterImpl;
import com.domain.vo.StaffInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/StaffFindAllServlet")
public class FindAllServlet extends HttpServlet {

    private StaffInter staffInter = new StaffInterImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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


        response.setContentType("text/json; charset=utf-8");

        //第二步：查询所有,调用dao获得数据
        List<StaffInfo> list = null;
        try {
            list = staffInter.findAllInfo();
//            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //第三步：把JSON数据作为流（数据流）返回给界面
        String jsonStr = JSON.toJSONString(list); //把list对象转化为JSON的数据对象，可以上传到前端的
        PrintWriter out = response.getWriter(); //从服务器获得管道（输出流）
        out.print(jsonStr); //通过response管道，输出JSON对象的数据
        out.flush();
        out.close(); //流的刷新和关闭
    }
}
