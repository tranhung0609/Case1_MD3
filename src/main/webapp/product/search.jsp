<%--
  Created by IntelliJ IDEA.
  User: hongh
  Date: 29/05/2022
  Time: 10:28 SA
  To change this template use File | Settings | File Templates.
--%>


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

<body>

<jsp:include page="find-css.jsp"/>

        <div class="container" >
            <div class="row">
                <c:forEach items="${products}" var="product">
                <div class="col mt-3">
                    <center>
                                <div class="product_image">
                                    <img style="height: 200px;width: 160px" src="${product.image}" alt="Loading...">
                                </div>
                                <div class="favorite favorite_left"></div>
                                <div class="product_bubble product_bubble_right product_bubble_red d-flex flex-column align-items-center">
                                    <span>-$20</span></div>
                                <div class="product_info">
                                    <h6 class="product_name"><a href="">${product.name}</a></h6></div>
                                <div class="product_info">
                                    <h6 class="product_name"><a href="">Số lượng hiện có :</a>${product.quantity}</h6>
                                </div>
                                <div class="product_price">$500<span>$${product.price}</span></div>
                    </center>
                            </div>

                </c:forEach>
                            </div>
                            </div>



</body>
</html>
