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
    <title>Danh sách sản phẩm</title>
<%--    <link rel="stylesheet" type="text/css" href="list-sell.css">--%>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="Colo Shop Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
    <link href="plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
    <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
    <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
    <link rel="stylesheet" type="text/css" href="styles/main_styles.css">
    <link rel="stylesheet" type="text/css" href="styles/responsive.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>


</head>
<body>
<div class="new_arrivals">
    <div class="container">
        <div class="row">
            <div class="col text-center">
                <div class="section_title new_arrivals_title">
                    <h2>Danh sách sản phẩm</h2>
                </div>
            </div>
        </div>
        <div class="row align-items-center">
            <div class="col text-center">
                <div class="new_arrivals_sorting">
                    <ul class="arrivals_grid_sorting clearfix button-group filters-button-group">
                        <li class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center active is-checked" data-filter="*">all</li>
                        <li class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center" data-filter=".women">women's</li>
                        <li class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center" data-filter=".accessories">accessories</li>
                        <li class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center" data-filter=".men">men's</li>
                    </ul>
                    <a href="/products?action=create" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Create</a>
                </div>
            </div>
        </div>

<div class="container">
    <div class="row">
        <div class="col mt-3">
            <div class="product-grid" data-isotope='{ "itemSelector": ".product-item", "layoutMode": "fitRows" }'>
                <c:forEach items="${products}" var="product">
                <div class="product-item accessories">
                    <div class="product discount product_filter">
                        <div class="product_image">
                            <img src="${product.image}" alt="">
                        </div>
                        <div class="favorite favorite_left"></div>
                        <div class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center"><span>-$20</span></div>
                        <div class="product_info">
                            <h6 class="product_name"><a href="">${product.name}</a></h6>
                            <h6 class="product_name"><a href="">Số lượng hiện có :</a>${product.quantity}</h6>
                            <div class="product_price">$500<span>$${product.price}</span></div>
                        </div>
                    </div>
                    <div class="red_button add_to_cart_button"><a href="">Edit</a></div>
                </div>
                </c:forEach>
</div>
<%--<h2>DANH SÁCH SẢN PHẨM CỦA MÌNH ĐỂ QUẢN LÝ</h2>--%>
<%--<c:forEach items="${products}" var="product">--%>
<%--    <div class="product-item men">--%>
<%--        <div class="product discount product_filter">--%>
<%--            <div class="product_image">--%>
<%--                <img src="${product.image}" alt="">--%>
<%--            </div>--%>
<%--            <div class="favorite favorite_left"></div>--%>
<%--            <div class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center"><span>-$20</span></div>--%>
<%--            <div class="product_info">--%>
<%--                <h6 class="product_name"><a href="">${product.name}</a></h6>--%>
<%--                <div class="product_price">$${product.price}<span>$590.00</span></div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="red_button add_to_cart_button"><a href="#">add to cart</a></div>--%>
<%--    </div>--%>
<%--</c:forEach>--%>
            <script src="js/jquery-3.2.1.min.js"></script>
            <script src="styles/bootstrap4/popper.js"></script>
            <script src="styles/bootstrap4/bootstrap.min.js"></script>
            <script src="plugins/Isotope/isotope.pkgd.min.js"></script>
            <script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
            <script src="plugins/easing/easing.js"></script>
            <script src="js/custom.js"></script>
</body>
</html>
