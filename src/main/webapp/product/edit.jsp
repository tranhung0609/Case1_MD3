<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 5/27/2022
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap CRUD Data Table for Database with Modal Form</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="css/manager.css" rel="stylesheet" type="text/css"/>
    <style>
        img {
            width: 200px;
            height: 120px;
        }
    </style>
<body>

<div class="container">
    <div class="table-wrapper">
        <div class="table-title">
            <div class="row">
                <div class="col-sm-6">
                    <h2>Add <b>Product</b></h2>
                </div>
                <div class="col-sm-6">
                </div>
            </div>
        </div>
    </div>

        <div id="editEmployeeModal">
            <div class="modal-dialog">
                <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">EDIT Product</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <form method="post" action="/products?action=edit">
                            <div class="form-group">
                                <input name="id" value="${product.id}" type="hidden">
                                <label>Name</label>
                                <input name="name" value="${product.name}" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Image</label>
                                <input name="image" value="${product.image}" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                <label>Price</label>
                                <input name="price" value="${product.price}" type="text" class="form-control" required>
                            </div>
                            <div class="form-group">
                                    <%--                            số lượng--%>
                                <label>Quantity</label>
                                <input name="quantity" value="${product.quantity}" type="text" class="form-control" required>
                            </div>

                            <div class="form-group">
                                <label>Category</label>
                                <select name="category"  class="form-control"
                                        aria-label="Default select example">
                                    <c:forEach items="${categories}" var="category">
                                        <option value="${category.id}">${category.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Promotion</label>
                                <select name="promotion" class="form-control"
                                        aria-label="Default select example">
                                    <c:forEach items="${promotions}" var="promotion">
                                        <option value="${promotion.id}">${promotion.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                                <div class="modal-footer">
                                    <input type="submit" class="btn btn-success" value="Edit">
                                </div>
                            </form>
                        </div>


                </div>
            </div>
        </div>



</div>


<script src="js/manager.js" type="text/javascript"></script>
</body>
</html>
