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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

</head>
<body>
<style>
    @import url('https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&display=swap');
    *{
        padding: 0;
        margin: 0;
    }
    body{
        font-family: 'Open Sans', sans-serif;
        font-size: 14px;
        color: #111;
        line-height: 1.15;
        background-image: url("https://png.pngtree.com/thumb_back/fw800/back_our/20190628/ourmid/pngtree-tech-lines-gray-background-image_275742.jpg");
    }
    #wrapper{
        max-width: 1170px;
        margin: 0 auto;
    }
    .headline{
        text-align: center;
        margin: 40px 0px;
    }
    h3{
        font-size: 18px;
        color: #111;
        padding: 10px 20px;
        text-transform: uppercase;
        border: 1px solid #bebebe;
        display: inline-block;
        color: #555;
        font-weight: 600;
    }
    ul.products{
        list-style: none;
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;
    }
    ul.product li{
        flex-basis: 25%;
        padding-left: 15px;
        padding-right: 15px;
        box-sizing: border-box;
        margin-bottom: 30px;
    }
    ul.product li img{
        max-width: 100%;
        height: auto;
    }
    ul.products li .product-top{
        position: relative;
        overflow: hidden;
    }
    ul.products li .product-top .product-thumb{
        display: block;
    }
    ul.products li:hover .product-top .product-thumb img{
        filter: opacity(80%);

    }
    ul.products li .product-top .product-thumb img{
        display: block;
    }
    ul.products li .product-top a.delete{
        text-transform: uppercase;
        text-decoration: none;
        text-align: center;
        display: block;
        background-color: #446084;
        color: #fff;
        padding: 10px 0px;
        position: absolute;
        bottom: -36px;
        width: 100%;
        transition: 0.25s ease-in-out;
        opacity: 0.85;

    }
    ul.products li:hover a.delete{
        bottom: 0px;
    }
    ul.products li .product-info{
        padding: 10px 0px;
    }
    ul.products li .product-info a{
        display: block;
        text-decoration: none;
    }
    ul.products li .product-info a.product-cat{
        font-size: 11px;
        text-transform: uppercase;
        color: #9e9e9e;
        padding: 3px 0px;
    }
    ul.products li .product-info a.product-name{
        color: #334862;
        padding: 3px 0px;
    }
    ul.products li .product-info .product-price{
        color: #111;
        padding: 2px 0px;
        font-weight: bold;
    }

</style>
<div id="wrapper">
    <div class="headline">
        <h3>List san pham</h3>
    </div>
    <button> <a href="/products?action=create" type="button" class="btn btn-outline-primary">Create</a> </button>
    <button> <a href="/products?action=edit&id=${product.id}" type="button" class="btn btn-outline-secondary">Edit</a> </button>
    <ul class="products">
        <c:forEach items="${products}" var="product">
            <li>
                <div class="product-item">
                    <div class="product-top">
                        <a href="" class="product-thumb">
                            <img src="${product.image}"alt="">
                        </a>
                        <a href="/products?action=delete&id=${product.id}" class="delete">delete</a>
                    </div>
                    <div class="product-info">
                        <a href="" class="product-cat">abc</a>
                        <a href="" class="product-name">${product.name}</a>
                        <div class="product-price">$${product.price}</div>
                    </div>
                </div>
            </li>
        </c:forEach>
<%--        <li>--%>
<%--            <div class="product-item">--%>
<%--                <div class="product-top">--%>
<%--                    <a href="" class="product-thumb">--%>
<%--                        <img src="/webapp/images/blog_3.jpg"alt="">--%>
<%--                    </a>--%>
<%--                    <a href="" class="edit">edit</a>--%>
<%--                </div>--%>
<%--                <div class="product-info">--%>
<%--                    <a href="" class="product-cat">abc</a>--%>
<%--                    <a href="" class="product-name">abc</a>--%>
<%--                    <div class="product-price">239</div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </li>--%>
    </ul>
</div>
<%--<div class="new_arrivals">--%>
<%--    <div class="container">--%>
<%--        <div class="row">--%>
<%--            <div class="col text-center">--%>
<%--                <div class="section_title new_arrivals_title">--%>
<%--                    <h2>Danh sách sản phẩm</h2>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <div class="row align-items-center">--%>
<%--            <div class="col text-center">--%>
<%--                <div class="new_arrivals_sorting">--%>
<%--                    <ul class="arrivals_grid_sorting clearfix button-group filters-button-group">--%>
<%--                        <li class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center active is-checked" data-filter="*">all</li>--%>
<%--                        <li class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center" data-filter=".women">women's</li>--%>
<%--                        <li class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center" data-filter=".accessories">accessories</li>--%>
<%--                        <li class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center" data-filter=".men">men's</li>--%>
<%--                    </ul>--%>
<%--                    <a href="/products?action=create" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Create</a>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>

<%--<div class="container">--%>
<%--    <div class="row">--%>
<%--        <div class="col mt-3">--%>
<%--            <div class="product-grid" data-isotope='{ "itemSelector": ".product-item", "layoutMode": "fitRows" }'>--%>
<%--                <c:forEach items="${products}" var="product">--%>
<%--                <div class="product-item accessories">--%>
<%--                    <div class="product discount product_filter">--%>
<%--                        <div class="product_image">--%>
<%--                            <img src="${product.image}" alt="">--%>
<%--                        </div>--%>
<%--                        <div class="favorite favorite_left"></div>--%>
<%--                        <div class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center"><span>-$20</span></div>--%>
<%--                        <div class="product_info">--%>
<%--                            <h6 class="product_name"><a href="">${product.name}</a></h6>--%>
<%--                            <h6 class="product_name"><a href="">Số lượng hiện có :</a>${product.quantity}</h6>--%>
<%--                            <div class="product_price">$500<span>$${product.price}</span></div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="red_button add_to_cart_button"><a href="/products?action=edit&id=${product.id}">Edit</a></div>--%>
<%--                    <div class="red_button add_to_cart_button"><a href="/products?action=delete&id=${product.id}">Delete</a></div>--%>
<%--                </div>--%>
<%--                </c:forEach>--%>
<%--</div>--%>
</body>
</html>
