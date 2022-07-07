<%--
  Created by IntelliJ IDEA.
  User: 86155
  Date: 2022/6/28
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%--
            c:if : 来完成逻辑判断，替换java中的if else
                test:写条件表达式
    --%>

    <c:if test="true">
        <h1>true</h1>
    </c:if>
    <c:if test="false">
        <h1>false</h1>
    </c:if>


    <%--
            c:foreach  :相当于for循环
                items:被遍历的容器
                var:临时变量
                varStatus:序号  index:从零开始 count:从一开始
                begin:开始数
                end:结束数
                step:步长     var（i）:循环变量i
    --%>
    <c:forEach items="${demo}" var="demo" varStatus="status">
        <tr>
            <td>${demo.id}</td>
            <td>${status.count}</td>
            <td>${demo.name}</td>
            <td>${demo.sex}</td>

        </tr>
    </c:forEach>

    <c:forEach begin="0" end="10" step="1" var="i">
        ${i}
    </c:forEach>
</body>
</html>
