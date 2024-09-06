
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="topnav">
    <div class="logo">
        <a href="home" class="hidden-sm"><h1>LOTY STORE</h1></a>
    </div>
    <div class="user-menu">
        <form action="#" method="post" class="hidden-sm">
<!--            <input type="text" name="search" id="search" placeholder="Search...">
            <i class="fa fa-search"></i>-->
        </form>
        <div>
            <c:if test="${sessionScope.acc != null}">
                <a href="managerH"><i class="fa fa-user"></i> ${sessionScope.acc.username}</a>
            </c:if>
            <a href="#" onclick="LoginMess()"><i class="fa fa-power-off"></i></a>
        </div>
    </div>
</nav>
