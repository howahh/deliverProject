package com.servlet.SrationServlet;

//展示驿站情况

import com.alibaba.fastjson.JSON;
import com.dao.StationInter;
import com.dao.impl.StationImpl;
import com.domain.Example;
import com.domain.Station;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/ShowStation")

public class ServletShowStation extends HttpServlet {
    StationInter station = new StationImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

            response.setContentType("text/html;charset=utf-8");
            request.setCharacterEncoding("utf-8");
            //解决中文乱码问题

            List<Station> list = station.findAll();
            String jsonStr = JSON.toJSONString(list);//转换为json格式
            PrintWriter out = response.getWriter(); //响应对象输出流
            out.print(jsonStr);
            out.flush();
            out.close();
            //通过流返回客户端
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
