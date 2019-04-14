<%@ page import="pl.sda.urbaniec.model.Order" %><%--
  Created by IntelliJ IDEA.
  User: Kasia
  Date: 13.04.2019
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>buy</title>
    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
    <link href="styles.css" rel="stylesheet" type="text/css"/>
    <jsp:include page="header.jsp"/>

</head>
<body>
<h1>YOUR ORDER</h1>
<p> Order address
    <%
        final Order order = (Order) session.getAttribute("order");
        out.println(order.getName() + " " + order.getSurname());
    %>
</p>
<jsp:include page="footer.jsp"/>
</body>
</html>
