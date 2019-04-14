<%@ page import="pl.sda.urbaniec.model.Cart" %>
<%@ page import="pl.sda.urbaniec.model.Product" %>
<%@ page import="java.util.Map" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kasia
  Date: 13.04.2019
  Time: 10:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>cart</title>
    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
    <link href="styles.css" rel="stylesheet" type="text/css"/>
    <jsp:include page="header.jsp"/>
</head>
<body>
<h1>SHOPPING LIST</h1>
<%
    final Cart cart = (Cart) session.getAttribute("cart");
    if (cart != null) {
        for (final Map.Entry<Product, Integer> entry : cart.get().entrySet()) {
%>
<p><%=entry.getKey().getName()%>
    price: <%=entry.getKey().getPrice() %> pln
    x <%=entry.getValue()%>
    value: <%=entry.getKey().getPrice() * entry.getValue()%> pln

<form action="${pageContext.request.contextPath}/addToCart" method="post">
    <input type="hidden" name="quantity" value="-1"/>
    <input type="hidden" value=<%=entry.getKey().getId()%> name="id"/>
    <button type="submit">-</button>
</form>
<form action="${pageContext.request.contextPath}/addToCart" method="post">
    <input type="hidden" name="quantity" value="1"/>
    <input type="hidden" value=<%=entry.getKey().getId()%> name="id"/>
    <button type="submit">+</button>
</form>
</p>
</p><a href="${pageContext.request.contextPath}/buy-data">ORDER</a></p>
<%
        }
    } else {
        out.println("empty list");
    }
%>

</body>
</html>
