<%--
  Created by IntelliJ IDEA.
  User: 86155
  Date: 2022/7/1
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <div id="loginDiv">
        <form action="/Demo1/loginServlet" method="post" id="form">
            <h1 id="loginMsg">LOGIN IN</h1>
            <p style="color: red">${tip}</p>
            <p>UserName:<input id="username" name="username" type="text" value="${cookie.username.value}"></p>
            <p>PassWord:<input id="password" name="password" type="password" value="${cookie.password.value}"></p>

            <div id="subDiv">
                <input type="submit" class="button" value="login up">
                <input type="reset" class="button" value="reset">
                <a href="register.jsp">没有账号？点击注册</a><br>
                记住我<input type="checkbox" name="remember" value="1" checked="checked">
            </div>

        </form>


    </div>

</body>
</html>
