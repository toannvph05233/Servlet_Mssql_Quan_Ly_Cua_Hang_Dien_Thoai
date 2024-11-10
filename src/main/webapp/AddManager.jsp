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
        <a href="managerH" class="active"><i class="fa fa-wrench"></i> Manager</a>
        <a href="invoice"><i class="fa fa-list"></i> Invoice</a>

        <a href="registry"><i class="fa fa-cogs"></i> Settings</a>
    </div>
</aside>

<main class="content">
    <div class="grid">
        <div class="painel">
            <div class="painel-header">
                <h4 class="painel-title">Thêm nhân viên</h4>
            </div>
            <div class="painel-body">
<!--                <div class="alert alert-danger">Failed</div>-->
                <form action="addmanager" class="inline-form" method="post">
                    <div class="group">
                        <label for="#">Mã nhân viên</label>
                        <input type="text" name="MANV" id="" placeholder="">
                    </div>
                    <div class="group">
                        <label for="#">Tên nhân viên</label>
                        <input type="text" name="TENNV" id="" placeholder="">
                    </div>
                    <div class="group">
                        <label for="#">CMND</label>
                        <input type="text" name="CMND" id="" placeholder="">
                    </div>
                    <div class="group">
                        <label for="#">Địa Chỉ</label>
                        <input type="text" name="DIACHI" id="" placeholder="">
                    </div>
                    <div class="group">
                        <label for="#">SĐT</label>
                        <input type="text" name="SDT" id="" placeholder="">
                    </div>
                    <div class="group">
                        <label for="#">Chức vụ</label>
                        <select name="MACV" id="">
                            <c:forEach items="${listCV}" var="o">
                                <option value="${o.MACV}">${o.TENCV}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="group">
                        <p>&nbsp;</p>
                        <input type="submit" class="btn btn-green search" style="width: 40%;" value="Thêm">
                    </div>
                </form>
            </div>
        </div>
    </div>
</main>
</body>
</html>
