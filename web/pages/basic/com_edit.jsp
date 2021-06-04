<%--
  Created by IntelliJ IDEA.
  User: 拾贰
  Date: 2020/11/19
  Time: 1:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Store Of LvTwelve</title>

    <%@ include file="/pages/basic/head.jsp"%>
</head>
<body>
<div>
    <form action="CommodityServlet" method="post">
        <input type="hidden" name="action" value="${ empty param.id ? "addCom" : "updCom"}"/>
        <input type="hidden" name="id" value="${requestScope.commodity.id }" />
        <table class="table table-bordered table-hover">
            <tr>
                <td align="center" ><b>名称</b></td>
                <td align="center" ><b>价格</b></td>
                <td align="center" ><b>商家</b></td>
                <td align="center" ><b>销售量</b></td>
                <td align="center" ><b>库存量</b></td>
            </tr>
            <tr>
                <td>
                    <label>
                    <input  type="text" name="name" value="${requestScope.commodity.name}"/>
                    </label>
                </td>
                <td>
                    <label>
                    <input  type="text" name="price" value="${requestScope.commodity.price}"/>
                    </label>
                </td>
                <td>
                    <label>
                    <input  type="text" name="business" value="${requestScope.commodity.business}"/>
                    </label>
                </td>
                <td>
                    <label>
                    <input  type="text" name="sales" value="${requestScope.commodity.sales}"/>
                    </label>
                </td>
                <td>
                    <label>
                    <input  type="text" name="stock" value="${requestScope.commodity.stock}"/>
                    </label>
                </td>
                <td><button type="submit">提交</button></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
