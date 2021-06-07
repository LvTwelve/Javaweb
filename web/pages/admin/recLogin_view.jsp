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

    <%@ include file="/pages/basic/head.jsp"%>
</head>
<body>
    <h2>登录记录查看</h2>
    <br/>
    <br/>
    <div>
        <table class="table table-bordered table-hover">
            <tr>
                <td style="text-align:center"><b>id</b></td>
                <td style="text-align:center"><b>userId</b></td>
                <td style="text-align:center"><b>登入时间</b></td>
                <td style="text-align:center"><b>登出时间</b></td>
                <td style="text-align:center"><b>ip</b></td>
                <td style="text-align:center"><b>级别</b></td>
            </tr>
            <c:forEach items="${requestScope.recordsLogin_all}" var="recLogin">
                <tr>
                    <td style="text-align:center">${recLogin.id}</td>
                    <td style="text-align:center">${recLogin.userId}</td>
                    <td style="text-align:center">${recLogin.loginTime}</td>
                    <td style="text-align:center">${recLogin.logoutTime}</td>
                    <td style="text-align:center">${recLogin.ip}</td>
                    <td style="text-align:center">${recLogin.level}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <br/>
    <br/>
    <button onclick="location.href='/web_shop/pages/admin/admin.jsp'">返回</button>
</body>
</html>
