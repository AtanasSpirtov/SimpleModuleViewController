<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add or Delete person</title>
</head>
<body>
<header>
    <h1>Add or Remove Person</h1>
</header>
<form action="InsertServlet" method="post">
    <input type="text" name="user_name">
    <input type="text" name="age">
    <input type="submit" value="Add" name="Add">
    <input type="submit" value="Remove">
</form>
</body>
<p>
<%--<form method="post" action="SuccessfullyInserted.jsp">--%>
</form>
</html>
