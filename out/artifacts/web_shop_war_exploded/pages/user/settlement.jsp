<%--
  Created by IntelliJ IDEA.
  User: 拾贰
  Date: 2020/11/20
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Store Of LvTwelve</title>

    <%@ include file="/pages/basic/head.jsp"%>
</head>
<body>
    <h2>结算页面</h2>
    <br/>
    <br/>
    <c:if test="${requestScope.itemName != null}">

        <p>商品 ${requestScope.itemName} 库存不足！</p>
        <p>创建订单失败！</p>
        <br/>
        <br/>
        <button onclick="location.href='/web_shop/pages/user/cart.jsp'">返回</button>
    </c:if>
    <c:if test="${requestScope.orderId != null}">
        <p>订单创建成功！</p>
        <p>订单号： ${requestScope.orderId}</p>
        <p>谢谢惠顾！</p>
        <br/>
        <br/>
        <button onclick="location.href='/web_shop/pages/user/cart.jsp'">返回</button>
    </c:if>
</body>
</html>
