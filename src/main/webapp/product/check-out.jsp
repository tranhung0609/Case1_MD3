<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 5/30/2022
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Check-out</title>
    <link type="text/css" href="/product/css/check-out.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"><script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
    <script src="js/jquery-1.11.1.min.js"></script>
</head>
<body>
<h2 class="text-center">Thanh toán</h2>
<div class="container">
    <table id="cart" class="table table-hover table-condensed">
        <thead>
        <tr>
            <th style="width:50%">Tên sản phẩm</th>
            <th style="width:10%">Giá</th>
            <th style="width:8%">Số lượng</th>
            <th style="width:22%" class="text-center">Thành tiền</th>
            <th style="width:10%"> </th>
        </tr>
        </thead>
        <tbody><tr>
            <td data-th="Product">
                <div class="row">
                    <div class="col-sm-2 hidden-xs"><img src="http://hocwebgiare.com/thiet_ke_web_chuan_demo/shopping_cart/images/090.jpg" alt="Sản phẩm 1" class="img-responsive" width="100">
                    </div>
                    <div class="col-sm-10">
                        <h4 class="nomargin">Sản phẩm 1</h4>
                        <p>Mô tả của sản phẩm 1</p>
                    </div>
                </div>
            </td>
            <td data-th="Price">200.000 đ</td>
            <td data-th="Quantity"><input class="form-control text-center" value="1" type="number">
            </td>
            <td data-th="Subtotal" class="text-center">200.000 đ</td>
            <td class="actions" data-th="">
                <button class="btn btn-danger btn-sm"><i class="fa fa-trash-o">Xóa</i>
                </button>
            </td>
        </tr>
        <tr>
            <td data-th="Product">
                <div class="row">
                    <div class="col-sm-2 hidden-xs"><img src="http://hocwebgiare.com/thiet_ke_web_chuan_demo/shopping_cart/images/174.jpg" alt="Sản phẩm 1" class="img-responsive" width="100">
                    </div>
                    <div class="col-sm-10">
                        <h4 class="nomargin">Sản phẩm 2</h4>
                        <p>Mô tả của sản phẩm 2</p>
                    </div>
                </div>
            </td>
            <td data-th="Price">300.000 đ</td>
            <td data-th="Quantity"><input class="form-control text-center" value="1" type="number">
            </td>
            <td data-th="Subtotal" class="text-center">300.000 đ</td>
            <td class="actions" data-th="">
                <button class="btn btn-danger btn-sm"><i class="fa fa-trash-o">Xóa</i>
                </button>
            </td>
        </tr>
        </tbody><tfoot>
    <tr class="visible-xs">
        <td class="text-center"><strong>Tổng 200.000 đ</strong>
        </td>
    </tr>
    <tr>
<%--        đã chuyền đường link quay trở lại mua hàng--%>
        <td><a href="/products?action=buy-list" class="btn btn-warning"><i class="fa fa-angle-left"></i> Tiếp tục mua hàng</a>
        </td>
        <td colspan="2" class="hidden-xs"> </td>
        <td class="hidden-xs text-center"><strong>Tổng tiền 500.000 đ</strong>
        </td>
<%--    truyền đường link thanh toán tiền--%>
        <td><a href="#" class="btn btn-success btn-block">Thanh toán <i class="fa fa-angle-right"></i></a>
        </td>
    </tr>
    </tfoot>
    </table>
</div>
</body>
</html>
