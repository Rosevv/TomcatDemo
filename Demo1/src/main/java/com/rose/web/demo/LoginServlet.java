package com.rose.web.demo;

import com.rose.mapper.UserMapper;
import com.rose.pojo.User;
import com.rose.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");


        /*String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);*/

        SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getSqlSessionFactory();


        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.Select(username, password);

        sqlSession.close();

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();

        if (user != null){

            if ("1".equals(remember)){
                Cookie cusername =new Cookie("username",username);
                Cookie cpassword =new Cookie("password",password);
                cusername.setMaxAge(60*60*24*7);
                cpassword.setMaxAge(60*60*24*7);

                response.addCookie(cusername);
                response.addCookie(cpassword);

            }
            writer.write(username+"登录成功");

        }else {
            String msg="用户名或密码错误";
            request.setAttribute("tip",msg);
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }
}
