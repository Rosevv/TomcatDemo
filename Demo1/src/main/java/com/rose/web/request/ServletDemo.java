package com.rose.web.request;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/*
* urlPattern：一个servlet可以配置多个访问路径  精确>目录>扩展名>任意
*   *精确匹配：urlPatterns = "/demo1/demo"
*   *目录匹配: urlPatterns = "/demo/*"
*   *扩展名匹配: urlPatterns = "*.do"  以.do结尾都可以访问到  不能以/开头
*   *任意匹配: urlPatterns = "/"   urlPatterns = "/*"  写什么都可以访问到  /*优先级更高一点  建议不用
*
*
* */
//@WebServlet(urlPatterns = "/demo1" , loadOnStartup = 1)
@WebServlet(urlPatterns = {"/demo1","/demoOne"})
public class ServletDemo implements Servlet {

    private ServletConfig config;


    /**
     * 初始化方法
     * 1、调用时机：默认情况下 servlet被第一次访问时
     *      *loadOnStartup:
     * 2、调用次数：1次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config=servletConfig;
        System.out.println("init");
    }


    @Override
    public ServletConfig getServletConfig() {
        return config;
    }


    /**
     * 提供服务
     * 1、调用时机：每一次servlet访问
     * 2、调用次数：多次
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        HttpServletRequest request= (HttpServletRequest) servletRequest;

        String method = request.getMethod();

        if ("get".equals(method)){
            //get的处理方式
        }else if("post".equals(method)){
            //post的处理方式
        }

        System.out.println("servlet Hello World");
    }

    @Override
    public String getServletInfo() {
        return null;
    }


    /**
     * 销毁方法
     * 1、调用时机：内存释放或服务器关闭的时候，servlet对象被销毁
     * 2、调用次数：1
     *
     */
    @Override
    public void destroy() {
        System.out.println("destory ,,,,");

    }
}
