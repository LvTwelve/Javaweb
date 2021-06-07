<%--
  Created by IntelliJ IDEA.
  User: 拾贰
  Date: 2020/11/22
  Time: 1:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Store Of LvTwelve</title>

    <%@ include file="/pages/basic/head.jsp"%>
</head>
<body>
    <h2>商品详细信息</h2>
    <br/>
    <br/>
    <table class="table table-bordered table-hover">
        <tr>
            <td style="text-align:center"><b>名称</b></td>
            <td style="text-align:center">${requestScope.commodity.name}</td>
        </tr>
        <tr>
            <td style="text-align:center"><b>价格</b></td>
            <td style="text-align:center">${requestScope.commodity.price}</td>
        </tr>
        <tr>
            <td style="text-align:center"><b>商家</b></td>
            <td style="text-align:center">${requestScope.commodity.business}</td>
        </tr>
        <tr>
            <td style="text-align:center"><b>销量</b></td>
            <td style="text-align:center">${requestScope.commodity.sales}</td>
        </tr>
        <tr>
            <td style="text-align:center"><b>库存</b></td>
            <td style="text-align:center">${requestScope.commodity.stock}</td>
        </tr>
    </table>
    <br/>
    <br/>
    <button value="${requestScope.commodity.id}" onclick="location.href='CartServlet?action=addItem&id='+value">加入购物车</button> |
    <button onclick="location.href='CommodityServlet?action=searComs_mall'" >返回</button>
</body>
</html>
