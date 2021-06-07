<%--
  Created by IntelliJ IDEA.
  User: 拾贰
  Date: 2021/6/5
  Time: 17:50
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
<h2>销售人员管理</h2>
<br/>
<br/>
<div>
    <table class="table table-bordered table-hover">
        <tr>
            <td style="text-align:center"><b>id</b></td>
            <td style="text-align:center"><b>账号</b></td>
            <td style="text-align:center"><b>密码</b></td>
            <td style="text-align:center"><b>邮箱</b></td>
            <td style="text-align:center"><b>操作</b></td>
            <td style="text-align:center"><b>操作</b></td>
        </tr>
        <c:forEach items="${requestScope.sales}" var="sale">
            <tr>
                <td style="text-align:center">${sale.id}</td>
                <td style="text-align:center">${sale.username}</td>
                <td style="text-align:center">${sale.password}</td>
                <td style="text-align:center">${sale.email}</td>
                <td style="text-align:center"><a
                        href="UserServlet?action=searSale_id&id=${sale.id}&opt=1">修改密码</a></td>
                <td style="text-align:center"><a href="UserServlet?action=searSale_id&id=${sale.id}&opt=2">修改级别</a>
                </td>
            </tr>
        </c:forEach>

    </table>
    <br/>
    <br/>
    <button onclick="location.href='/web_shop/pages/admin/admin.jsp'">返回</button>
</div>
</body>
</html>
