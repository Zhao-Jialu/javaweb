<%@ page import="com.service.BrandService" %><%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2022/3/18
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% String id = request.getParameter("id");
    request.setAttribute("brand",id);
%>
<form action="/brand-demo/deleteServlet" method="post">
    <%--隐藏域，提交id--%>
    <input type="hidden" name="id" value="${brand}">
    确定删除?
        <input type="radio" name="choice" value="0">确定
        <input type="radio" name="choice" value="1">取消
    <input type="submit" value="提交">
</form>
</body>
</html>
