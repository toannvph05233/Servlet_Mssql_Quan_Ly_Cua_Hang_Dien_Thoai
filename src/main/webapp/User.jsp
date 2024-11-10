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
        <a href="user" class="active"><i class="fa fa-users"></i> User</a>
        <a href="product"><i class="fa fa-edit"></i> Product</a>
        <a href="managerH"><i class="fa fa-wrench"></i> Manage</a>
        <a href="invoice"><i class="fa fa-list"></i> Invoice</a>

        <a href="registry"><i class="fa fa-cogs"></i> Settings</a>
    </div>
</aside>

<main class="content">
    
    <div class="grid">
        <div class="painel">
            <div class="painel-header">
                <h4 class="painel-title">User</h4>
                <a href="adduser" class="btn btn-green">Thêm khách hàng</a> 
            </div>
            <div class="painel-body">
                <table class="zebra">
                    <tr>
                        <th>Mã khách hàng</th>
                        <th>Họ tên</th>
                        <th>SDT</th>
                        <th>Actions</th>
                    </tr>
                    <c:forEach items="${listU}" var="o">
                        <tr>
                            <td>${o.MAKH}</td>
                            <td>${o.TENKH}</td>
                            <td>${o.SDT}</td>
                            <td>
                                <a href="updateuser?uid=${o.MAKH}" class="btn btn-orange"><i class="fa fa-edit"></i></a>
                                <a href="#" onclick="showMessU('${o.MAKH}')" class="btn btn-red"><i class="fa fa-trash"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>

        
    </main>
    <script src="js/main.js"></script>
</body>
</html>
