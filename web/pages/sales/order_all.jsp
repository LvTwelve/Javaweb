<%--
  Created by IntelliJ IDEA.
  User: 拾贰
  Date: 2020/11/20
  Time: 1:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Store Of LvTwelve</title>

    <%@ include file="/pages/basic/head.jsp" %>

</head>
<body>
<div>
    <h2>订单</h2>
    <br/>
    <br/>
</div>
<table class="table table-bordered table-hover">
    <tr>
        <td align="center"><b>订单号</b></td>
        <td align="center"><b>时间</b></td>
        <td align="center"><b>金额</b></td>
        <td align="center"><b>状态</b></td>
        <td></td>
    </tr>

    <c:forEach items="${requestScope.order_all}" var="orders">
        <tr>
            <td align="center">${orders.orderId}</td>
            <td align="center">${orders.createTime}</td>
            <td align="center">${orders.price}</td>
            <td align="center">
                <c:if test="${orders.status == 0}">
                    未完成
                </c:if>
                <c:if test="${orders.status == 1}">
                    已完成
                </c:if>
                <c:if test="${orders.status == 2}">
                    售后处理中
                </c:if>
            </td>
            <td align="center">
                <button value="${orders.orderId}"
                        onclick="location.href='OrderItemServlet?action=searOrderItem&id='+value">详情
                </button>
            </td>
        </tr>
    </c:forEach>
</table>
<br/>
<br/>
<button onclick="location.href='/web_shop/pages/sales/sales.jsp'">返回</button>
</body>
</html>
