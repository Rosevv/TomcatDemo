package com.rose.web.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/aServlet")
public class AServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //cookie
        //Cookie cookie=new Cookie("username","zs");

        //cookie里面不能设置中文会报错   利用解码编码解决
        String name="李四";
        String value = URLEncoder.encode(name,"UTF-8");

        Cookie cookie=new Cookie("username",value);



        response.addCookie(cookie);
    }
}
