package com.rose.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
* servlet多了不好管理   我们自定义他的方法分发来根据用户提交的路径后的名来调用相应的servlet的方法
* 如 http://localhost:8080/Demo1/selectAll  我们就找到路径最后的发放名来调用
* */
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、获取请求路径
        String uri = req.getRequestURI();
        //2、获取最后一段路径
        int index=uri.lastIndexOf("/");
        String methodName = uri.substring(index + 1);

        //3、执行方法
        //获取相应servlet的字节码对象class
        //这里的this是 谁调用这个service this就是谁 因为下面的servlet继承了BaseServlet所以this代表下面的servlet
        Class<? extends BaseServlet>  cls = this.getClass();
        //获取方法method对象
        try {
            Method method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            //执行方法
            method.invoke(this,req,resp);

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }
}
