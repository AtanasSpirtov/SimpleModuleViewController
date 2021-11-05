=<%@ page import="com.example.demo2.OutServlet" %>
<%@ page import="People.Person" %>
<%@ page import="java.util.List" %>


<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>JJJJJJJ</title>
</head>
<body>
<table border=1>
    <tr><th>Id</th><th>Name</th><th>Age</th></tr>
    <% List<Person> personList = (List<Person>) request.getAttribute("users");
        for(Person row: personList) {
    %>
    <tr>
        <td><%= row.getId() %></td>
        <td><%=row.getUserName()%></td>
        <td><%=row.getAge() %></td>
    </tr>
    <%} %>

</table>
</body>
</html>
