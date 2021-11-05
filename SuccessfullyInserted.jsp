<%--
  Created by IntelliJ IDEA.
  User: spirt
  Date: 28/10/2021
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% String username = (String) request.getParameter("user_name");
    String age = (String) request.getParameter("age");
    %>
<td><%= username %></td>
<td><%= age %></td>
<form action="InsertServlet">
    <input type="submit">
</form>
</body>
</html>
