<%--
  Created by IntelliJ IDEA.
  User: 86155
  Date: 2022/7/1
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="form-div">
        <h1>欢迎注册</h1>
        <span>已有账号？</span><a href="login.jsp">登录</a>
    </div>
    <form action="/Demo1/registerServlet" method="post" id="req-form">
        <table>
            <tr>
                <td>用户名</td>
                <td class="inputs">
                    <input name="username" type="text" id="username"><br>
                </td>
            </tr>
            <tr>
                <td>密码</td>
                <td>
                    <input name="password" type="password" id="password">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="注册">
                </td>


            </tr>
        </table>

    </form>


</body>
</html>
