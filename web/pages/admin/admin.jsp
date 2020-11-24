<%--
  Created by IntelliJ IDEA.
  User: 拾贰
  Date: 2020/11/20
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Store Of LvTwelve</title>

    <%@ include file="/pages/basic/head.jsp" %>
</head>
<body>
<div>
    <h2>管理员主页</h2>
    <br/>
    <br/>
</div>

    <form action="CommodityServlet" method="post">
        <input type="hidden" name="action" value="searComs_manage"/>
        <button type="submit">商品管理</button>
    </form>
    <br/>
    <form action="OrderServlet" method="post">
        <input type="hidden" name="action" value="searOrders"/>
        <button type="submit">订单查看</button>
    </form>
    <br/>
    <form action="RecordServlet" method="post">
        <input type="hidden" name="action" value="searRec_all"/>
        <button type="submit">浏览记录查看</button>
    </form>
</body>
</html>
