<%-- 
    Document   : Home
    Created on : Apr 14, 2021, 6:17:49 PM
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
        <a href="product" class="active"><i class="fa fa-edit"></i> Product</a>
        <a href="managerH"><i class="fa fa-wrench"></i> Manage</a>
        <a href="invoice"><i class="fa fa-list"></i> Invoice</a>
        <a href="Notification.jsp"><i class="fa fa-bell"></i> Notification</a>
        <a href="registry"><i class="fa fa-cogs"></i> Settings</a>
    </div>
</aside>

<main class="content">
    <div class="grid">
        <div class="painel">
            <div class="painel-header">
                <h4 class="painel-title">Lọc sản phẩm</h4>
            </div>
            <div class="painel-body">
                <form action="filterproduct?cid=${tag}" class="inline-form" method="post">
<!--                    <div class="group">
                        <label for="#">Sắp xếp theo giá</label>
                        <select name="MALOAI" id="">
                            <option value="giam">Từ cao => thấp</option>
                            <option value="tang">Từ thấp => cao</option>
                        </select>
                    </div>-->
                    <div class="group">
                        <label for="#">Loại mặt hàng</label>
                        <select name="MALOAI" id="">
                            <option value="all">Tất cả</option>
                            <c:forEach items="${listC}" var="o">
                                <option value="${o.MALOAI}">${o.TENLOAI}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="group">
                        <p>&nbsp;</p>
                        <input type="submit" class="btn btn-green search" style="width: 40%;" value="Search">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="grid">
        <div class="painel">
            <div class="painel-header">
                <h4 class="painel-title">Sản phẩm</h4>
                <a href="addproduct" class="btn btn-green">Thêm sản phẩm</a>
            </div>
            <div class="painel-body">
                <table class="zebra">
                    <tr>
                        <th>Mã mặt hàng</th>
                        <th>Tên mặt hàng</th>
                        <th>Giá</th>
                        <th>Actions</th>
                    </tr>
                    <c:forEach items="${listP}" var="o">
                        <tr>
                            <td>${o.maMH}</td>
                            <td>${o.tenMH}</td>
                            <td>${o.giaMH}$</td>
                            <td>
                                <a href="updateproduct?pid=${o.maMH}" class="btn btn-orange"><i class="fa fa-edit"></i></a>
                                <a href="#" onclick="showMessP('${o.maMH}')" class="btn btn-red"><i class="fa fa-trash"></i></a>
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
