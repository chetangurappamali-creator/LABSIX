 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Welcome Page</title>
</head>
<body>

<%
    String name = request.getParameter("uname");

    out.println("<h2>Welcome " + name + "</h2>");
    out.println("<p>Session Started...</p>");

    // Store value in session
    session.setAttribute("user", name);

    // Set session expiry time (1 minute = 60 seconds)
    session.setMaxInactiveInterval(60);

    out.println("<p>Session expiry time is 1 minute</p>");
%>

<br>
<a href="second.jsp">Check Session Value</a>

</body>
</html>