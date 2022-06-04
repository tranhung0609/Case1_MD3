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
    <title>Product List</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
                crossorigin="anonymous"></script>
    <link rel="stylesheet" href="coloshop-master/styles/style.css" type="text/css">

</head>

<body>
<jsp:include page="csslist-sell.jsp"/> <%--css  giao diện--%>
<div id="wrapper">
    <div class="headline">
        <h2>Product List</h2>
        <form  method="post">
            <button class="btn-hover color-5"><a href="/products?action=create">Create</a></button>
        </form>
    </div>
    <ul class="products">
        <c:forEach items="${products}" var="product">
            <li>
                <div class="product-item">
                    <div>
                        <div class="product-top">

                            <div class="product-item">
                                <a href="${product.image}" class="product-image">
                                    <img style="height: 240px;width: 200px" src="${product.image}" alt="">
                                </a>
                            </div>
                            <div class="product-info">
                                <a href="" class="product-name"><b>${product.name}</b></a>
                            </div>
                        </div>
                    </div>
                    <div class="product-price">$${product.price}</div>
                    <div> <button class="btn-hover color-1" style="width: 80px; height: 30px ;margin: 5px;transform: translateX(70%)"><a href="/products?action=edit&id=${product.id}">Edit</a></button></div>
                    <div
                            class="product-top"><button class="btn-hover color-2" style="width: 80px;height: 30px; margin: 5px;transform: translateX(70%)"><a href="/products?action=delete&id=${product.id}">Delete</a></button>
                    </div>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
<center>
    <button class="btn-hover color-3"><a href="/products"  >Back</a></button>
</center>
</body>
</html>
