<%-- 
    Document   : Home
    Created on : Apr 14, 2024, 6:17:49 PM
    Author     : admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Loty Store</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.css">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<jsp:include page="Top.jsp"></jsp:include>
<aside class="sidenav hidden-sm hidden-md" id="nav">
    <div class="list">
        <a href="home"><i class="fa fa-home"></i> Home</a>
        <a href="user"><i class="fa fa-users"></i> User</a>
        <a href="product"><i class="fa fa-edit"></i> Product</a>
        <a href="managerH"><i class="fa fa-wrench"></i> Manage</a>
        <a href="invoice"><i class="fa fa-list"></i> Invoice</a>
<%--        <a href="Notification.jsp" class="active"><i class="fa fa-bell"></i> Notification</a>--%>
        <a href="registry"><i class="fa fa-cogs"></i> Settings</a>
    </div>
</aside>

<main class="content">
    <script>
        alert("Đang cập nhật!");
    </script>
</main>
<script src="js/main.js"></script>
</body>
</html>
