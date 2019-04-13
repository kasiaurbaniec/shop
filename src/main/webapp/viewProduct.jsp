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
    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans" rel="stylesheet">
    <link href="styles.css" rel="stylesheet" type="text/css"/>
    <script src="https://use.fontawesome.com/releases/v5.8.1/js/all.js" data-auto-replace-svg="nest"></script>
    <jsp:include page="header.jsp"/>
</head>
<body>
<div>
    <c:choose>
        <c:when test="${newProduct.isPresent()}">
            <
            <h4>${newProduct.get().getName()}</h4>
            <p><img src=${newProduct.get().getHref()}  height="100" alt="photo of item"/></p>
            <p>
            <li>id: ${newProduct.get().getId()}</li>
            </p>
            <p>
            <li>description: ${newProduct.get().getDescription()}</li>
            </p>
            <p>
            <li>price: ${newProduct.get().getPrice()}</li>
            </p>
            <p>
            <li>category: ${newProduct.get().getCategories()}</li>
            </p>
            <form action="${pageContext.request.contextPath}/addToCart" method="post">
                <p>quantity <input type="number" name="quantity" value="0"/></p>
                <input type="hidden" value="${newProduct.get().getId()}" name="id"/>
                <button type="submit">
                    <i class="fas fa-shopping-cart"></i> BUY
                </button>
            </form>
        </c:when>
        <c:otherwise> product doesn't exists</c:otherwise>
    </c:choose>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
