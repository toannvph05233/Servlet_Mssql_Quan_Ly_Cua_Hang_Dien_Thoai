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
        <a href="home" class="active"><i class="fa fa-home"></i> Home</a>
        <a href="user"><i class="fa fa-users"></i> User</a>
        <a href="product"><i class="fa fa-edit"></i> Product</a>
        <a href="managerH"><i class="fa fa-wrench"></i> Manage</a>
        <a href="invoice"><i class="fa fa-list"></i> Invoice</a>
        <a href="registry"><i class="fa fa-cogs"></i> Settings</a>
    </div>
</aside>

<main class="content">
    <div class="grid">
        <div class="mini-reports bg-blue">
                <div class="l">
                    <span>${user}</span>
                    <span>Users</span>
                </div>
                <div class="r">
                    <i class="fa fa-users c-blue"></i>
                </div>
        </div>
        <div class="mini-reports bg-green">
                <div class="l">
                    <span>${product}</span>
                    <span>Products</span>
                </div>
                <div class="r">
                    <i class="fas fa-mobile c-green"></i>
                </div>
        </div>
        <div class="mini-reports bg-orange">
                <div class="l">
                    <span>${money} $</span>
                    <span>Total Profit</span>
                </div>
                <div class="r">
                    <i class="fas fa-donate c-orange"></i>
                </div>
        </div>
        <div class="mini-reports bg-red">
                <div class="l">
                    <span>${order}</span>
                    <span>Total Orders</span>
                </div>
                <div class="r">
                    <i class="fa fa-user c-red"></i>
                </div>
        </div>
    </div>

    <div class="grid">
        <div class="painel">
            <div class="painel-header">
                <h4 class="painel-title">Sản Phẩm</h4>
            </div>
            <div class="painel-body">
                <table class="zebra">
                    <tr>
                        <th>Mã Mặt Hàng</th>
                        <th>Tên Mặt Hàng</th>
                        <th>Giá</th>
                    </tr>
                    <c:forEach items="${listP}" var="o">
                        <tr>
                            <td>${o.maMH}</td>
                            <td>${o.tenMH}</td>
                            <td>${o.giaMH}$</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

        <div class="painel">
            <div class="painel-header">
                <h4 class="painel-title">Hóa Đơn</h4>
                <a href="addinvoice" class="btn btn-green">Thêm hóa đơn</a>
            </div>
            <div class="painel-body">
                <table class="zebra">
                    <tr>
                        <th>Mã hóa đơn</th>
                        <th>Ngày lập hóa đơn</th>
                        <th>Khách hàng</th>
                        <th>Nhân viên</th>
                        <th>Tổng tiền</th>
                    </tr>
                    <c:forEach items="${listI}" var="o">
                        <tr>
                            <td>${o.maHD}</td>
                            <td>${o.getNgayLapHD()}</td>
                            <td>${o.maKH}</td>
                            <td>${o.maNV}</td>
                            <td>${o.getTongTien()}$</td>
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
