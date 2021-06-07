<%--
  Created by IntelliJ IDEA.
  User: 拾贰
  Date: 2020/11/20
  Time: 1:45
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Store Of LvTwelve</title>

    <%@ include file="/pages/basic/head.jsp"%>
</head>
<body>
<h2>订单详情</h2>
<br/>
<br/>
<c:if test="${empty requestScope.orderItems}">
    <p>订单详情消失了。</p>
    <br/>
    <br/>
    <c:if test="${sessionScope.user.id != 1}">
        <button onclick="location.href='OrderServlet?action=searOrder_id'">返回</button>
    </c:if>
    <c:if test="${sessionScope.user.id == 1}">
        <button onclick="location.href='OrderServlet?action=searOrders'">返回</button>
    </c:if>
</c:if>
<c:if test="${not empty requestScope.orderItems}">
    <table class="table table-bordered table-hover">
        <tr>
            <td style="text-align:center"><b>名称</b></td>
            <td style="text-align:center"><b>数量</b></td>
            <td style="text-align:center"><b>单价</b></td>
            <td style="text-align:center"><b>总价</b></td>
        </tr>

        <c:forEach items="${requestScope.orderItems}" var="orderItem">
            <tr>
                <td style="text-align:center">${orderItem.name}</td>
                <td style="text-align:center">${orderItem.count}</td>
                <td style="text-align:center">${orderItem.price}</td>
                <td style="text-align:center">${orderItem.totalPrice}</td>
            </tr>
        </c:forEach>
    </table>
    <br/>
    <br/>
    <c:if test="${sessionScope.user.id != 1}">
        <button onclick="location.href='OrderServlet?action=searOrder_id'">返回</button>
    </c:if>
    <c:if test="${sessionScope.user.id == 1}">
        <button onclick="location.href='OrderServlet?action=searOrders'">返回</button>
    </c:if>
</c:if>

</body>
</html>
