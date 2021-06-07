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
    <h2>操作日志查看</h2>
    <br/>
    <br/>
    <div>
        <table class="table table-bordered table-hover">
            <tr>
                <td style="text-align:center"><b>id</b></td>
                <td style="text-align:center"><b>操作时间</b></td>
                <td style="text-align:center"><b>userId</b></td>
                <td style="text-align:center"><b>ip</b></td>
                <td style="text-align:center"><b>内容</b></td>
                <td style="text-align:center"><b>级别</b></td>
            </tr>
            <c:forEach items="${requestScope.recordsOper_all}" var="recOper">
                <tr>
                    <td style="text-align:center">${recOper.id}</td>
                    <td style="text-align:center">${recOper.operTime}</td>
                    <td style="text-align:center">${recOper.userId}</td>
                    <td style="text-align:center">${recOper.ip}</td>
                    <td style="text-align:center">${recOper.content}</td>
                    <td style="text-align:center">${recOper.level}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <br/>
    <br/>
    <button onclick="location.href='/web_shop/pages/admin/admin.jsp'">返回</button>
</body>
</html>
