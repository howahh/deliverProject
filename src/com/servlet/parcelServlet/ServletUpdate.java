package com.servlet.parcelServlet;

import com.dao.impl.ParcelImpl;
import com.domain.Parcel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 2020/7/20 -0:33
 **/
@WebServlet("/updateparcel")
public class ServletUpdate extends HttpServlet {
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
        response.setHeader("content-type","text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String parcel_id=request.getParameter("parcel_id");
        String parcel_num=request.getParameter("parcel_num");
        String compy_id=request.getParameter("compy_id");
        String receiver_name=request.getParameter("receiver_name");
        String sender_name = request.getParameter("sender_name");
        String receiver_city = request.getParameter("receiver_city");
        String sender_city = request.getParameter("sender_city");
        String parcel_city=request.getParameter("parcel_city");
        String parcel_zhuangtai=request.getParameter("parcel_zhuangtai");
        String station_id = request.getParameter("station_id");
        Parcel parcel = new Parcel();
        parcel.setParcel_id(Integer.valueOf(parcel_id));
        parcel.setParcel_num(Integer.valueOf(parcel_num));
        parcel.setCompy_id(Integer.valueOf(compy_id));
        parcel.setReceiver_name(receiver_name);
        parcel.setSender_name(sender_name);
        parcel.setReceiver_city(receiver_city);
        parcel.setSender_city(sender_city);
        parcel.setParcel_city(parcel_city);
        parcel.setParcel_zhuangtai(parcel_zhuangtai);
        parcel.setStation_id(Integer.valueOf(station_id));
        try {
            parcelimpl.update(parcel);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
