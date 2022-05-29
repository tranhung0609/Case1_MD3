<%--
  Created by IntelliJ IDEA.
  User: hongh
  Date: 29/05/2022
  Time: 9:44 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Chi tiết sản phẩm</h2>
<h3>
    ${product.id},${product.name},${product.price},${product.image},${product.quantity},${product.quantitySold},${product.category.name},${product.promotion.name},${product.account.email}
</h3>
<a href="/products?action=buy-list">TRỞ LẠI</a>
</body>
</html>
