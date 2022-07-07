package com.rose.web.response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/resp1")
public class ResponseDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //重定向
        //设置响应状态码
        //response.setStatus(302);
        //设置相应头
        //response.setHeader("Location","/Demo1/resp2");

        //动态获取虚拟目录
        String path = request.getContextPath();


        //简化方式完成重定向
        response.sendRedirect(path+"/resp2");//可以重定向到任何位置  包括网络连接

        System.out.println("resp1....");
    }
}
