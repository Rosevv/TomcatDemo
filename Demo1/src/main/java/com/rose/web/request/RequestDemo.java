package com.rose.web.request;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@WebServlet("/req")
public class RequestDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");//post方法的解决

        String username = request.getParameter("username");
        //get  post通用
        //中文乱码原因Tomcat进行URL解码，默认的字符集时ISO-8859-1
        //先对乱码数据进行编码，转化为字节数组
        byte[] bytes = username.getBytes("ISO-8859-1");

        //字节数组解码
        username= new String(bytes, StandardCharsets.UTF_8);

        System.out.println("解决乱码"+username);



        Map<String, String[]> map = request.getParameterMap();

        for(String key:map.keySet()){
            System.out.print(key+"：");

            String[] values = map.get(key);
            for(String value:values){
                System.out.print(value);
            }
            System.out.println();

        }

    }
}
