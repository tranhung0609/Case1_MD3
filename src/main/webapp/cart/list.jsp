<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hongh
  Date: 30/05/2022
  Time: 12:21 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/orders" method="post">
<c:forEach items="${cartItems}" var="cartItem">
    <h3>${cartItem.getProduct().getName()}, ${cartItem.quantity}, ${cartItem.price}</h3>
</c:forEach>
    <a href="/orders?action=buy&totalPrice=${totalPrice}"></a>
</form>
</body>
</html>
