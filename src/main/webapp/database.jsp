<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kasia
  Date: 30.03.2019
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Smar_mydlo_i_powidlo</title>
    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
    <link href="styles.css" rel="stylesheet" type="text/css"/>
    <jsp:include page="header.jsp"/>
    <div>
        <form action="${pageContext.request.contextPath}/database" method="get">
            <p>category <select name="category">
                <option value="">All</option>
                <option value="Furniture">Furniture</option>
                <option value="Light">Light</option>
                <option value="Other items">Other items</option>
            </select>
            </p>
            <%--name= ma się tak samo nazywać jak parametr w servlecie--%>
            <p><input type="submit" name="submit" value="show"/></p>
        </form>
    </div>
</head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:forEach items="${products}" var="product">
    <div class="block">
        <a href="${pageContext.request.contextPath}/viewProduct?id=${product.getId()}"><h4>${product.getName()}</h4></a>
        <p><img src=${product.getHref()}  height="100" alt="photo of item"/></p>
        <ul>
            <li>id: ${product.getId()}</li>
            <li>desciption: ${product.getDescription()}</li>
            <li>price: ${product.getPrice()}</li>
            <li>category: ${product.getCategories()}</li>
        </ul>
    </div>

</c:forEach>
<div class="advertisement">
    <h4>${advert.getName()}</h4>
    <p>price: ${advert.getPrice()}</p>
    <p><img src=${advert.getHref()}  height="50" alt="photo of item"/></p>

</div>
<div id="footer">
    <jsp:include page="footer.jsp"/>
</div>
</body>
</html>
