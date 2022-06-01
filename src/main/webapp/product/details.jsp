<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: hongh
  Date: 29/05/2022
  Time: 9:44 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>Harvest vase</title>
    <link href="https://fonts.googleapis.com/css?family=Bentham|Playfair+Display|Raleway:400,500|Suranna|Trocchi" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="product/css/details.css">
</head>
<body>
<div class="product-card">
    <div class="badge">${product.promotion.getName()}</div>
    <div class="product-tumb">
        <img src="${product.image}" alt="">
    </div>
    <div class="product-details">
        <span class="product-catagory">${product.category.name}</span>
        <h4><a href="">${product.name}</a></h4>
        <h5 class="product-quantity">Số lượng hiện có : ${product.quantity}</h5>
        <br>
        <h5 class="product-quantitySold">Số lượng đã bán : ${product.quantitySold}</h5>
        <h4 class="Account">Người bán : ${account.name}</h4>

<%--        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Vero, possimus nostrum!</p>--%>
        <div class="product-bottom-details">
            <div class="product-price"><small>${product.promotion.name}</small>$${product.price}</div>
            <div class="product-links">
                <a href="/orders?action=add-to-cart"><i class="fa fa-heart"></i>Buy Now</a>
                <a href="/products?action=buy-list"><i class="fa fa-shopping-cart"></i>Back</a>
            </div>
        </div>
    </div>
</div>

</body>

</html>

<%--<html>--%>
<%--<head>--%>
<%--    <title>Title</title>--%>
<%--    <link rel="stylesheet" type="text/css" href="css/details.css">--%>
<%--    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">--%>
<%--    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>--%>
<%--    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>--%>
<%--    <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800&display=swap" rel="stylesheet">--%>
<%--    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">--%>
<%--    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css">--%>
<%--    <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.theme.default.min.css">--%>

<%--</head>--%>
<%--<body>--%>
<%--<div class="pd-wrap">--%>
<%--<div class="container">--%>
<%--    <div class="heading-section">--%>
<%--        <h2>Product Details</h2>--%>
<%--    </div>--%>
<%--    <div class="row">--%>
<%--        <div class="col-md-6">--%>
<%--            <div id="slider" class="owl-carousel product-slider">--%>
<%--                <div class="item">--%>
<%--                    <img src="${product.image}">--%>
<%--                </div>--%>
<%--        </div>--%>
<%--        <div class="col-md-6">--%>
<%--            <div class="product-dtl">--%>
<%--                <div class="product-info">--%>
<%--                    <div class="product-name">${product.name}</div>--%>
<%--                    <div class="product-price-discount"><span>$${product.promotion.name}</span><span class="line-through">$${product.price}</span></div>--%>
<%--                </div>--%>
<%--                <p></p>--%>

<%--                <div class="product-count">--%>
<%--                    &lt;%&ndash;@declare id="size"&ndash;%&gt;<label for="size">Quantity</label>--%>
<%--                    <form action="#" class="display-flex">--%>
<%--                        <div class="qtyminus">-</div>--%>
<%--                        <input type="text" name="quantity" value="${product.quantity}" class="qty">--%>
<%--                        <div class="qtyplus">+</div>--%>
<%--                    </form>--%>
<%--                    <a href="/orders?action=add-to-cart" class="round-black-btn">Add to Cart</a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>--%>
<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity=" sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>--%>
<%--<h2>Chi tiết sản phẩm</h2>--%>
<%--<h3>--%>
<%--    ${product.id},${product.name},${product.price},${product.image},${product.quantity},${product.quantitySold},${product.category.name},${product.promotion.name},${product.account.email}--%>
<%--</h3>--%>
<%--<a href="/products?action=buy-list">TRỞ LẠI</a>--%>

