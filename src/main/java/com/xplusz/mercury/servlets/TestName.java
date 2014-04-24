package com.xplusz.mercury.servlets;
import com.xplusz.mercury.services.DButil;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;




/**
 * Created by allenli on 4/24/14.
 */
public class TestName extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {


        doPost(request, response);
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) {

        //request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=null;
        DButil db=new DButil();
        try {
             out = response.getWriter();
        }catch(Exception e)
        {}
        // 取得页面的值
        String name = request.getParameter("name");
        if (name == null || "".equals(name)) {
            out.println("name can't be null");
        } else {
            if (db.testname(name)) {
                out.println("<font color='red'>该用户名:" + name + "已经存在，请选用其它用户名</font>");
            } else {
                out.println("<font color='red'>该用户名：" + name + "还没有被注册</font>");
            }
        }
        out.flush();
        out.close();
    }

}
