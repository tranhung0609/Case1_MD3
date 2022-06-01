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
</head>

<body>
<jsp:include page="csslist-sell.jsp"/> <%--css  giao diện--%>
<div id="wrapper">
    <div class="headline">
        <h2>Product List</h2>
        <form method="post">
            <button><a href="/products?action=create" type="button" class="btn btn-outline-primary">Create</a></button>
        </form>
    </div>
    <ul class="products">
        <c:forEach items="${ds}" var="product">
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
                            <div class="product-price">$${product.price}</div>
                            <div> <a href="/products?action=edit&id=${product.id}" type="button"
                                     class="btn btn-outline-primary">Edit</a></div>
                            <div
                                    class="product-top"><a href="/products?action=delete&id=${product.id}" type="button"
                                                           class="btn btn-outline-primary">Delete</a>
                            </div>
                        </div>
                    </div>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
