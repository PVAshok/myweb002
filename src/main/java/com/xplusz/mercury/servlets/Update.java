package com.xplusz.mercury.servlets;

import com.xplusz.mercury.services.DButil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by allenli on 4/24/14.
 */
public class Update extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");//设置服务器响应的内容格式
        // response.setCharacterEncoding("gb2312");//设置服务器响应的字符编码格式。
        DButil ab = new DButil();
        try {
            PrintWriter pw = response.getWriter();
            String tep=new String(request.getParameter("tid").getBytes("ISO-8859-1"));
             String name = new String(request.getParameter("name").getBytes("ISO-8859-1"));
            int id=Integer.valueOf(tep);
            System.out.println("update id"+id);
            if(ab.update(id,name)) {

                request.getRequestDispatcher("succ.jsp?info='update success'").forward(request, response);

            }



        } catch (Exception e) {
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);///调用doGet方法
    }
}