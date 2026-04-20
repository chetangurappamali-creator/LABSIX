<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Session Check</title>
</head>
<body>

<h2>Session Value Page</h2>

<%
    String name = (String) session.getAttribute("user");

    if (name == null) {
        out.println("<h3 style='color:red'>Sorry, Session has expired!</h3>");
    } else {
        out.println("<h3 style='color:green'>Hello " + name + "</h3>");
    }
%>

</body>
</html>