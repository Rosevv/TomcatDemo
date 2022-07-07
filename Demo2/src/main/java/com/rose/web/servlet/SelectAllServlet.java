package com.rose.web.servlet;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.rose.joke.Brand;
import com.rose.mapper.BrandMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.rose.util.SqlSeeionFactoryUtils;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelectAllServlet")
public class SelectAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SqlSessionFactory sessionFactory= SqlSeeionFactoryUtils.getSqlSession();
        SqlSession sqlSession = sessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();


        //        request.getParameter()无法接受JSON的数据
        //解决  获取请求体
        //  BufferedReader reader = request.getReader();
        //  String readLine = reader.readLine();
        //将JSON数据转化为java对象
        //  JSONObject jsonObject = JSON.parseObject(readLine,Brand.class);

        String s = JSON.toJSONString(brands);

        System.out.println(s);
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().write(s);


        //request.getRequestDispatcher("brand.html").forward(request,response);

    }
}
