<%--
  Created by IntelliJ IDEA.
  User: 拾贰
  Date: 2020/11/19
  Time: 0:57
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
    <h2>猜你喜欢</h2>
    <br/>
    <br/>
    <div>
        <table class="table table-bordered table-hover">
            <tr>
                <td style="text-align:center"><b>*</b></td>
                <td style="text-align:center"><b>名称</b></td>
                <td style="text-align:center"><b>价格</b></td>
                <td style="text-align:center"><b>操作</b></td>
                <td style="text-align:center"><b>操作</b></td>

            </tr>
            <c:forEach items="${requestScope.commodities}" var="com">
                <tr>
                    <td style="text-align:center">*</td>
                    <td style="text-align:center">${com.name}</td>
                    <td style="text-align:center">${com.price}</td>
                    <td style="text-align:center"><button value="${com.id}" name="${com.name}" onclick="location.href='RecordServlet?action=addRec&comId='+value+'&comName='+name">查看详情</button></td>
                    <td style="text-align:center"><button value="${com.id}" onclick="location.href='CartServlet?action=addItem&id='+value">加入购物车</button></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
