<%--
  Created by IntelliJ IDEA.
  User: 拾贰
  Date: 2020/11/22
  Time: 1:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Store Of LvTwelve</title>

    <%@ include file="/pages/basic/head.jsp" %>
</head>
<body>
<h2>浏览记录查看</h2>
<br/>
<br/>
<div>
    <table class="table table-bordered table-hover">
        <tr>
            <td align="center"><b>用户</b></td>
            <td align="center"><b>商品</b></td>
            <td align="center"><b>名称</b></td>
            <td align="center"><b>时间</b></td>
        </tr>
        <c:forEach items="${requestScope.records_all}" var="rec">
            <tr>
                <td align="center">${rec.userId}</td>
                <td align="center">${rec.comId}</td>
                <td align="center">${rec.comName}</td>
                <td align="center">${rec.createTime}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<br/>
<br/>
<button onclick="location.href='/web_shop/pages/sales/sales.jsp'">返回</button>
</body>
</html>
