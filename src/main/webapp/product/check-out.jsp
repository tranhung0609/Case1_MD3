<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
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
            <th style="width:10%"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${myCartItems}" var="cartItem">
            <form action="/orders" method="get">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="cartItemId" value="${cartItem.getCartItemId()}">

                <tr>
                    <td data-th="Product">
                        <div class="row">
                            <div class="col-sm-2 hidden-xs"><img src="${cartItem.getProduct().getImage()}"
                                                                 alt="Sản phẩm 1"
                                                                 class="img-responsive" width="100">
                            </div>
                            <div class="col-sm-10">
                                <h4 class="nomargin">${cartItem.getProduct().getName()}</h4>
                                    <%--                        <p>Mô tả của sản phẩm 1</p>--%>
                            </div>
                        </div>
                    </td>
                    <td data-th="Price" id="price${cartItem.product.id}">${cartItem.getProduct().getPriceByPromotion()}</td>
                    <td data-th="Quantity">${cartItem.quantity}
<%--                        <input type="text" class="data-th" style="width: 40px;" id="quan${cartItem.product.id}"--%>
<%--                               onchange="calPriceByQuantity(${cartItem.product.id})" value="${cartItem.quantity}">--%>
                    </td>
                    <td data-th="Subtotal" class="text-center print"
                        id="print${cartItem.product.id}">${cartItem.price}</td>
                    <td class="actions" data-th="">
                        <button class="btn btn-danger btn-sm"><i
                                class="fa fa-trash-o">Xóa</i>
                        </button>
                    </td>
                </tr>
            </form>
        </c:forEach>
        <h1 id="sum"></h1>
        </tbody>
        <script>
            function calPriceByQuantity(id) {
                let a = +document.getElementById("price" + id).innerHTML;
                let b = +document.getElementById("quan" + id).value;
                document.getElementById("print" + id).innerHTML = (a * b);
                let sum = 0;
                for (let i = 0; i < document.getElementsByClassName('print').length; i++) {
                    sum += +document.getElementsByClassName('print')[i].innerHTML;
                }
                document.getElementById("sum").innerHTML = sum;
                console.log(sum);
            }

        </script>

        <tfoot>
        <tr>
            <%--        đã chuyền đường link quay trở lại mua hàng--%>
            <td><a href="/products?action=buy-list" class="btn btn-warning"><i class="fa fa-angle-left"></i> Tiếp tục
                mua hàng</a>
            </td>
            <td colspan="2" class="hidden-xs"></td>
            <td class="hidden-xs text-center" id="printTotal"><strong>Tổng tiền $${totalPrice}</strong>
            </td>
            <%--    truyền đường link thanh toán tiền--%>
            <td><a href="/orders?action=buy" class="btn btn-success btn-block">Thanh toán<i
                    class="fa fa-angle-right"></i></a>
            </td>
        </tr>
        </tfoot>
    </table>
</div>

</body>
</html>
