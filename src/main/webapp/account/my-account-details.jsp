<%--
  Created by IntelliJ IDEA.
  User: hongh
  Date: 29/05/2022
  Time: 10:15 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Information account detaill</h2>
<table border="1" cellspacing="0">
    <tr><td>ID</td><td>NAME</td><td>EMAIL</td><td>ADDRESS</td><td>PASSWORD</td></tr>
    <tr><td>${acc.id}</td><td>${acc.name}</td><td>${acc.email}</td><td>${acc.address}</td><td>${acc.password}</td></tr>
</table>
<a href="/products"><button>Back</button></a>
</body>
</html>
