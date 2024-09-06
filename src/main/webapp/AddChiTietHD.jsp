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
        <a href="product"><i class="fa fa-edit"></i> Product</a>
        <a href="managerH"><i class="fa fa-wrench"></i> Manage</a>
        <a href="invoice" class="active"><i class="fa fa-list"></i> Invoice</a>
        <a href="Notification.jsp"><i class="fa fa-bell"></i> Notification</a>
        <a href="registry"><i class="fa fa-cogs"></i> Settings</a>
    </div>
    </aside>


    <main class="content">
        <div class="grid">
            <div class="painel">
                <div class="painel-header">
                    <h4 class="painel-title">Thêm chi tiết hóa đơn</h4>
                </div>
                <div class="painel-body">
                    <form action="addchitiethd" class="inline-form" method="post">
                        <div class="group">
                            <label for="#">Mã hóa đơn</label>
                            <input type="text" name="maHD" value="${upI.maHD}" readonly>
                        </div>
                        <div class="group">
                            <label for="#">Sản phẩm</label>
                            <select name="maMH" onchange="showPrice()" id="getvalue">
                                <c:forEach items="${listP}" var="o">
                                    <option data-price="${o.giaMH}" value="${o.maMH}">${o.tenMH}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="group">
                            <label for="#">Số lượng</label>
                            <input type="text" name="SL">
                        </div>
                        <div class="group">
                            <label for="#">Đơn giá</label>
                            <input type="text" id="dongia" name="DonGia">
                        </div>
                        <div class="group">
                            <label for="#">Mã khuyến mãi</label>
                            <input type="text" name="maKM">
                        </div>
                        <div class="group">
                            <p>&nbsp;</p>
                            <input type="submit" class="btn btn-green search" style="width: 40%;" value="Thêm">
                        </div>
                    </form>
                </div>
                <div class="painel-body">
                    <table class="zebra">
                        <tr>
                            <th>Mã hóa đơn</th>
                            <th>Mã sản phẩm</th>
                            <th>Số lượng</th>
                            <th>Đơn giá</th>
                            <th>Mã khuyến mãi</th>
                            <th>Thành tiền</th>
                        </tr>
                        <c:forEach items="${listCT}" var="o">
                            <tr>
                                <td>${o.maHD}</td>
                                <td>${o.maMH}</td>
                                <td>${o.SL}</td>
                                <td>${o.getDonGia()}$</td>
                                <td>${o.maKM}</td>
                                <td>${o.getThanhTien()}$</td>
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
