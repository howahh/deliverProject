package com.servlet.parcelServlet;

import com.alibaba.fastjson.JSON;
import com.dao.impl.ParcelImpl;
import com.domain.Parcel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 2020/7/19 -16:08
 **/
@WebServlet("/ServletFindByNum")
public class ServletFindByNum extends HttpServlet {
    ParcelImpl parcelimpl = new ParcelImpl();
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
        String num=request.getParameter("parcel_num");
        int parcel_num = Integer.parseInt(num);
        try {
            Parcel parcel=parcelimpl.findByNum(parcel_num);
            String jsonStr = JSON.toJSONString(parcel);//转换为json格式
            PrintWriter out = response.getWriter(); //响应对象输出流
            out.print(jsonStr);
            out.flush();
            out.close();
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
        request.setCharacterEncoding("UTF-8");
        String num=request.getParameter("parcel_num");
        int parcel_num = Integer.parseInt(num);
        try {
            Parcel parcel=parcelimpl.findByNum(parcel_num);
            String jsonStr = JSON.toJSONString(parcel);//转换为json格式
            PrintWriter out = response.getWriter(); //响应对象输出流
            out.print(jsonStr);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
