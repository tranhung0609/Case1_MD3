<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 5/26/2022
  Time: 2:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Register</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="css/style.css">

</head>
<body class="form-v7">
<section class="ftco-section">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-6 text-center mb-5">
                <h2 class="heading-section"></h2>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="col-md-12 col-lg-10">
                <div class="wrap d-md-flex">
                    <div class="img" style="background-image: url(/login-form-14/images/pexels-yugdas-manandhar-2876658.jpg);">
                    </div>
                    <div class="login-wrap p-4 p-md-5">
                        <div class="d-flex">
                            <div class="w-100">
                                <h3 class="mb-4">Sign In</h3>
                            </div>
                            <div class="w-100">
                                <p class="social-media d-flex justify-content-end">
                                    <a href="#" class="social-icon d-flex align-items-center justify-content-center"><span class="fa fa-facebook"></span></a>
                                    <a href="#" class="social-icon d-flex align-items-center justify-content-center"><span class="fa fa-twitter"></span></a>
                                </p>
                            </div>
                        </div>
                        <form action="<%=request.getContextPath()%>/accounts?action=signup" class="signin-form" method="post">
                            <div class="form-group mb-3">
                                <label class="label" for="username">Username</label>
                                <input type="text" name="name" id="username" class="form-control" placeholder="Username">
                            </div>
                            <div class="form-group mb-3">
                                <label class="label" for="your_email" >E-MAIL</label>
                                <input type="text" name="email" id="your_email" class="form-control" placeholder="E-Mail" required pattern="[^@]+@[^@]+.[a-zA-Z]{2,6}">
                            </div>
                            <div class="form-group mb-3">
                                <label class="label" for="your_address" >ADDRESS</label>
                                <input type="text" name="address" id="your_address" class="form-control" placeholder="Address" required>
                            </div>
                            <div class="form-group mb-3">
                                <label class="label" for="password" >PASSWORD</label>
                                <input type="password" name="password" id="password" class="form-control" placeholder="Password" required>
                            </div>
                            <div class="form-group mb-3">
                                <label class="label" for="comfirm_password" >CONFIRM PASSWORD</label>
                                <input type="password" name="comfirmPassword" id="comfirm_password" class="form-control" placeholder="Confirm Password" required>
                            </div>
<%--                            <div class="form-group mb-3">--%>
<%--                                <input type="submit" name="register" class="register" value="Register" href="/homepage/minishop-master/minishop-master/shop.jsp">--%>
<%--                            </div>--%>
                            <div class="form-group">
                                <button type="submit" name="register" class="form-control btn btn-primary rounded submit px-3" href="/accounts?action=signup">Register</button>
                            </div>
                            <div class="form-group d-md-flex">
                                <div class="w-50 text-left">
                                    <label class="checkbox-wrap checkbox-primary mb-0">Remember Me
                                        <input type="checkbox" checked>
                                        <span class="checkmark"></span>
                                    </label>
                                </div>
                                <div class="w-50 text-md-right">
                                </div>
                            </div>
                        </form>
<%--                        <p class="text-center">Not a member? <a href="register.jsp">Sign Up</a></p>--%>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<script src="js/jquery.min.js"></script>
<script src="js/popper.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/main.js"></script>

</body>
</html>


