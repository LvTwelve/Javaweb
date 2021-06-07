<%--
  Created by IntelliJ IDEA.
  User: 拾贰
  Date: 2020/11/9
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>


<%
    String basePath = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";

    pageContext.setAttribute("basePath",basePath);
%>
<base href="<%=basePath%>">

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>

<div>
    <%--未登录--%>
    <c:if test="${empty sessionScope.user}">
        <nav class="navbar navbar-default">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand">  Lv.Twelve.  </a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav navbar-left">
                        <li><a href="index.jsp">主页</a></li>
                        <li><a href="CommodityServlet?action=searComs_mall">购物</a></li>
                        <li><a href="pages/user/login.jsp">登录</a></li>
                        <li><a href="pages/user/regist.jsp">注册</a></li>
                    </ul>
                </div><!-- /.navbar-collapse -->
            </div><!-- /.container-fluid -->
        </nav>

    </c:if>
    <%--已登录--%>
    <c:if test="${ not empty sessionScope.user}">
        <%-- 管理员 --%>
        <c:if test="${sessionScope.user.level == 1}">
            <nav class="navbar navbar-default">
                <div class="container">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand">LvTwelve</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                        <ul class="nav navbar-nav navbar-left">
                            <li><a href="index.jsp">主页</a></li>
                            <li><a href="CommodityServlet?action=searComs_mall">购物</a></li>
                            <li><a href="pages/user/cart.jsp">购物车</a></li>
                            <li><a href="pages/admin/admin.jsp">管理员主页</a></li>
                            <li><a href="CommodityServlet?action=searComs_manage">商品管理</a></li>
                            <li><a href="OrderServlet?action=searOrders">订单查看</a></li>
                            <li><a href="RecordServlet?action=searRec_all">浏览记录查看</a></li>
                            <li><a href="UserServlet?action=logout">注销</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>

        </c:if>

        <%-- 销售人员 --%>
        <c:if test="${sessionScope.user.level == 2}">
            <nav class="navbar navbar-default">
                <div class="container">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand">LvTwelve</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-3">
                        <ul class="nav navbar-nav navbar-left">
<%--                            <li><a href="index.jsp">主页</a></li>--%>
<%--                            <li><a href="CommodityServlet?action=searComs_mall">购物</a></li>--%>
<%--                            <li><a href="pages/user/cart.jsp">购物车</a></li>--%>
                            <li><a href="pages/sales/sales.jsp">销售人员主页</a></li>
                            <li><a href="CommodityServlet?action=searComs_manage">商品管理</a></li>
                            <li><a href="OrderServlet?action=searOrders">订单查看</a></li>
                            <li><a href="RecordServlet?action=searRec_all">浏览记录查看</a></li>
                            <li><a href="UserServlet?action=logout">注销</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>

        </c:if>

        <%-- 非管理员 --%>
        <c:if test="${sessionScope.user.level == 3}">
            <nav class="navbar navbar-default">
                <div class="container">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand">LvTwelve</a>
                    </div>

                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-4">
                        <ul class="nav navbar-nav navbar-left">
                            <li><a href="index.jsp">主页</a></li>
                            <li><a href="CommodityServlet?action=searComs_mall">购物</a></li>
                            <li><a href="OrderServlet?action=searOrder_id">订单</a></li>
                            <li><a href="pages/user/cart.jsp">购物车</a></li>
                            <li><a href="CommodityServlet?action=commenComs">猜你喜欢</a></li>
                            <li><a href="UserServlet?action=logout">注销</a></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                </div><!-- /.container-fluid -->
            </nav>
        </c:if>
    </c:if>

</div>