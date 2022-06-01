<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/31/2022
  Time: 11:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <head>
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
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
              integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
                integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
                crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
                crossorigin="anonymous"></script>


    </head>
</head>
<body>

<div class="new_arrivals">
    <div class="container">
        <div class="row">
            <div class="col text-center">
                <div class="section_title new_arrivals_title">
                    <h2>you can choose what you want!!</h2>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="row align-items-center">
    <div class="col text-center">
        <div class="new_arrivals_sorting">
            <ul class="arrivals_grid_sorting clearfix button-group filters-button-group">
                <li class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center active is-checked"
                    data-filter="*">all
                </li>
                <li class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center"
                    data-filter=".women">women's
                </li>
                <li class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center"
                    data-filter=".accessories">accessories
                </li>
                <li class="grid_sorting_button button d-flex flex-column justify-content-center align-items-center"
                    data-filter=".men">men's
                </li>
            </ul>
            <form method="post">
                <input type="text" name="name" placeholder="Find">
                <button class="btn btn-success">Search by name</button>
            </form>
            <br/>
            <form action="/products?action=findDesc" method="post">
                <select><option>Desc price</option><option>Asc price</option></select>
                <button class="btn btn-success">Search by Desc</button>
            </form>


        </div>
    </div>
</div>
<script src="js/jquery-3.2.1.min.js"></script>
<script src="styles/bootstrap4/popper.js"></script>
<script src="styles/bootstrap4/bootstrap.min.js"></script>
<script src="plugins/Isotope/isotope.pkgd.min.js"></script>
<script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
<script src="plugins/easing/easing.js"></script>
<script src="js/custom.js"></script>
</body>
</html>
