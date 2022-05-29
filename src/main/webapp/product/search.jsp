<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hongh
  Date: 29/05/2022
  Time: 10:28 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <input type="text" name="name">
    <button>SEARCH</button>
</form>

<h2>Các sản phẩm cần tìm</h2>
<c:forEach items="${products}" var="product">
    <h3>${product.name}</h3>
</c:forEach>
</body>
</html>
