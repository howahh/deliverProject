package com.servlet.parcelServlet;

import com.alibaba.fastjson.JSON;
import com.dao.impl.ParcelImpl;
import com.domain.Example;
import com.domain.Parcel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 2020/7/19 -17:39
 **/
@WebServlet("/servletinsert")
public class ServletInsert extends HttpServlet {
    ParcelImpl parcelimpl = new ParcelImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            request.setCharacterEncoding("UTF-8");
            /**
             * 从页面获取信息进行存储
             * 以存储了的信息新建一个insert对象
             * 调用dao层插入数据到数据库
             */
            String receiver_name=request.getParameter("receiver_name");
            String sender_name = request.getParameter("sender_name");
            String receiver_city = request.getParameter("receiver_city");
            String sender_city = request.getParameter("sender_city");
            String compy_id1 = request.getParameter("compy_id");
            int compy_id =Integer.valueOf(compy_id1);
            int min=200000;int max=400000;
            int parcel_num= min+(int)(Math.random()*(max-min+1));
            List<Parcel> list = parcelimpl.findAll();
            int parcel_id=0;
            for(int i=0;i<list.size();++i){
                parcel_id=list.get(i).getParcel_id();
            }
            parcel_id+=1;
            min=0;max=4;
            String parcel_city = "成都";
            int rannum = min+(int)(Math.random()*(max-min+1));
            switch (rannum){
                case 0:parcel_city="上海";
                    break;
                case 1:parcel_city="北京";
                    break;
                case 2:parcel_city="成都";
                    break;
                case 3:parcel_city="武汉";
                    break;
                case 4:parcel_city="长沙";
            }
            String parcel_zhuangtai;
            if(parcel_city.equals("成都"))
                parcel_zhuangtai="到达";
            else
                parcel_zhuangtai="途中";
            min=1;max=10;
            int station_id=min+(int)(Math.random()*(max-min+1));
            Parcel parcel =new Parcel();
            parcel.setParcel_id(parcel_id);
            parcel.setParcel_num(parcel_num);
            parcel.setCompy_id(compy_id);
            parcel.setReceiver_name(receiver_name);
            parcel.setSender_name(sender_name);
            parcel.setReceiver_city(receiver_city);
            parcel.setSender_city(sender_city);
            parcel.setParcel_city(parcel_city);
            parcel.setParcel_zhuangtai(parcel_zhuangtai);
            parcel.setStation_id(station_id);
//            System.out.println(parcel);
            parcelimpl.insert(parcel);
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
        /**
         * 从页面获取信息进行存储
         * 以存储了的信息新建一个insert对象
         * 调用dao层插入数据到数据库
         */
        String receiver_name=request.getParameter("receiver_name");
        String sender_name = request.getParameter("sender_name");
        String receiver_city = request.getParameter("receiver_city");
        String sender_city = request.getParameter("sender_city");
        String compy_id1 = request.getParameter("compy_id");
        int compy_id =Integer.valueOf(compy_id1);
        int min=200000;int max=400000;
        int parcel_num= min+(int)(Math.random()*(max-min+1));
        List<Parcel> list = null;
        try {
            list = parcelimpl.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int parcel_id=0;
        for(int i=0;i<list.size();++i){
            parcel_id=list.get(i).getParcel_id();
        }
        parcel_id+=1;
        min=0;max=4;
        String parcel_city = "成都";
        int rannum = min+(int)(Math.random()*(max-min+1));
        switch (rannum){
            case 0:parcel_city="上海";
                break;
            case 1:parcel_city="北京";
                break;
            case 2:parcel_city="成都";
                break;
            case 3:parcel_city="武汉";
                break;
            case 4:parcel_city="长沙";
        }
        String parcel_zhuangtai;
        if(parcel_city.equals("成都"))
            parcel_zhuangtai="到达";
        else
            parcel_zhuangtai="途中";
        min=1;max=10;
        int station_id=min+(int)(Math.random()*(max-min+1));
        Parcel parcel =new Parcel();
        parcel.setParcel_id(parcel_id);
        parcel.setParcel_num(parcel_num);
        parcel.setCompy_id(compy_id);
        parcel.setReceiver_name(receiver_name);
        parcel.setSender_name(sender_name);
        parcel.setReceiver_city(receiver_city);
        parcel.setSender_city(sender_city);
        parcel.setParcel_city(parcel_city);
        parcel.setParcel_zhuangtai(parcel_zhuangtai);
        parcel.setStation_id(station_id);
//        System.out.println(parcel);
        try {
            parcelimpl.insert(parcel);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
