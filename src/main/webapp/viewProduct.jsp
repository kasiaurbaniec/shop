<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Kasia
  Date: 06.04.2019
  Time: 12:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>view</title>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div>
    <c:choose>
        <c:when test="${newProduct.isPresent()}">

            <h4>${newProduct.get().getName()}</h4>
            <p><img src=${newProduct.get().getHref()}  height="100" alt="photo of item"/></p>
            <p>
            <li>id: ${newProduct.get().getId()}</li>
            </p>
            <p>
            <li>data zamówienia: ${newProduct.get().getDate()}</li>
            </p>
            <p>
            <li>opis: ${newProduct.get().getDescription()}</li>
            </p>
            <p>
            <li>cena: ${newProduct.get().getPrice()}</li>
            </p>
            <p>
            <li>kategoria: ${newProduct.get().getCategories()}</li>
            </p>
        </c:when>
        <c:otherwise> product doesn't exists</c:otherwise>
    </c:choose>
</div>
</body>
</html>
