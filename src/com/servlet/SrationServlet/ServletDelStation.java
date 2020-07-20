package com.servlet.SrationServlet;

//删除功能的servlet

import com.alibaba.fastjson.JSON;
import com.dao.impl.ExampleImpl;
import com.dao.impl.ManagerImpl;
import com.dao.impl.StationImpl;
import com.domain.Example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Delstation")

public class ServletDelStation extends HttpServlet{
   private StationImpl servletDelStation = new StationImpl();
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

   }

   /**
    *
    * @param request:请求对象，请求中的所有信息都可以从对象中获得
    * @param response:响应对象，要返回的响应都可以通过这个对象去返回
    * @throws ServletException
    * @throws IOException
    */
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

      int id = Integer.parseInt(request.getParameter("id"));//获得要删除的id
      try {

         new StationImpl().delete(id);
         //new ManagerImpl().delete(id);

      } catch (Exception e) {
         e.printStackTrace();
      }


   }
}
