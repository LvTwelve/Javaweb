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

    <script type="text/javascript">
        $(function () {
            //删除确认提示操作
            $("a.deleteClass").click(function () {
                return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】?");
            });
        });
    </script>
</head>
<body>
    <h2>商品管理</h2>
    <br/>
    <br/>
    <div>
        <table class="table table-bordered table-hover">
            <tr>
                <td align="center" ><b>名称</b></td>
                <td align="center" ><b>价格</b></td>
                <td align="center" ><b>商家</b></td>
                <td align="center" ><b>销售量</b></td>
                <td align="center" ><b>库存量</b></td>
                <td align="center" ><b>操作</b></td>
                <td align="center" ><b>操作</b></td>
            </tr>
            <c:forEach items="${requestScope.commodities}" var="com">
                <tr>
                    <td align="center" >${com.name}</td>
                    <td align="center" >${com.price}</td>
                    <td align="center" >${com.business}</td>
                    <td align="center" >${com.sales}</td>
                    <td align="center" >${com.stock}</td>
                    <td align="center" ><a href="CommodityServlet?action=searCom_id&id=${com.id}&com_edit=true">修改</a></td>
                    <td align="center" ><a class="deleteclass" href="CommodityServlet?action=delCom&id=${com.id}">删除</a></td>
                </tr>
            </c:forEach>

        </table>
        <br/>
        <br/>
        <button onclick="location.href='../basic/com_edit.jsp'">添加商品</button> |
        <button onclick="location.href='/web_shop/pages/sales/sales.jsp'">返回</button>
    </div>
</body>
</html>
