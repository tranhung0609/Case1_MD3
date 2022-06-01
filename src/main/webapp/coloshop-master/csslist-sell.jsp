<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/30/2022
  Time: 11:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    @import url('https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&display=swap');

    * {
        padding: 0;
        margin: 0;
    }

    body {
        font-family: 'Open Sans', sans-serif;
        font-size: 14px;
        color: #111;
        line-height: 1.15;
        background-image: url("https://png.pngtree.com/thumb_back/fw800/back_our/20190628/ourmid/pngtree-tech-lines-gray-background-image_275742.jpg");
    }

    #wrapper {
        max-width: 1170px;
        margin: 0 auto;
    }

    .headline {
        text-align: center;
        margin: 40px 0px;
    }

    h3 {
        font-size: 18px;
        color: #111;
        padding: 10px 20px;
        text-transform: uppercase;
        border: 1px solid #bebebe;
        display: inline-block;
        color: #555;
        font-weight: 600;
    }

    ul.products {
        list-style: none;
        display: flex;
        flex-wrap: wrap;
        justify-content: space-between;
    }

    ul.product li {
        flex-basis: 25%;
        padding-left: 15px;
        padding-right: 15px;
        box-sizing: border-box;
        margin-bottom: 30px;
    }

    ul.product li img {
        max-width: 100%;
        height: auto;
    }

    ul.products li .product-top {
        position: relative;
        overflow: hidden;
    }

    ul.products li .product-top .product-thumb {
        display: block;
    }

    ul.products li:hover .product-top .product-thumb img {
        filter: opacity(80%);

    }

    ul.products li .product-top .product-thumb img {
        display: block;
    }

    ul.products li .product-top a.edit {
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

    ul.products li:hover a.edit {
        bottom: 0px;
    }

    ul.products li .product-info {
        padding: 10px 0px;
    }

    ul.products li .product-info a {
        display: block;
        text-decoration: none;
    }

    ul.products li .product-info a.product-cat {
        font-size: 11px;
        text-transform: uppercase;
        color: #9e9e9e;
        padding: 3px 0px;
    }

    ul.products li .product-info a.product-name {
        color: #334862;
        padding: 3px 0px;
    }

    ul.products li .product-info .product-price {
        color: #111;
        padding: 2px 0px;
        font-weight: bold;
    }

</style>