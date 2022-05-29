<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hongh
  Date: 29/05/2022
  Time: 12:23 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>DANH SÁCH SẢN PHẨM CỦA MÌNH ĐỂ QUẢN LÝ</h2>
<c:forEach items="${products}" var="product">
    <div class="product-item men">
        <div class="product discount product_filter">
            <div class="product_image">
                <img src="images/product_1.png" alt="">
            </div>
            <div class="favorite favorite_left"></div>
            <div class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center"><span>-$20</span></div>
            <div class="product_info">
                <h6 class="product_name"><a href="">${product.name}</a></h6>
                <div class="product_price">$${product.price}<span>$590.00</span></div>
            </div>
        </div>
        <div class="red_button add_to_cart_button"><a href="#">add to cart</a></div>
    </div>
</c:forEach>
</body>
</html>
