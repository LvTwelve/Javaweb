<%--
  Created by IntelliJ IDEA.
  User: 拾贰
  Date: 2020/11/19
  Time: 15:32
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
            $("button.deleteItem").click(function () {
                return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】?");
            });

            //清空购物车 - 确认提示操作
            $("button.clearCart").click(function () {
                return confirm("你确定要清空购物车嘛?");
            });

            //数量更改
            $("input.updItem").change(function () {
                if ( confirm("你确定要将【" + $(this).parent().parent().parent().find("td:first").text() + "】商品修改数量为：" + this.value + " 吗?") ) {
                    location.href = "CartServlet?action=updItem_count&id="+this.id+"&count="+this.value;
                } else {
                    this.value = 1;
                }
            });
        });
    </script>
</head>
<body>
    <h2>购物车</h2>
    <br/>
    <br/>
    <div>
            <%-- 购物车为空 --%>
            <c:if test="${empty sessionScope.cart.itemMap}">
                <p>空空如也！</p>
                <br/>
                <br/>
                <form action="CommodityServlet" method="post">
                    <input type="hidden" name="action" value="searComs_mall"/>
                    <button type="submit">开始购物</button>
                </form>
            </c:if>
            <%-- 购物车不为空 --%>
            <c:if test="${not empty sessionScope.cart.itemMap}">
                <table class="table table-bordered table-hover">
                    <tr>
                        <td align="center"><b>名称</b></td>
                        <td align="center"><b>数量</b></td>
                        <td align="center"><b>单价</b></td>
                        <td align="center"><b>总价</b></td>
                        <td align="center"> </td>
                    </tr>
                    <c:forEach items="${sessionScope.cart.itemMap}" var="item">
                        <tr>
                            <td align="center">${item.value.name}</td>
                            <td align="center">${item.value.price}</td>
                            <td align="center">
                                <label>
                                    <input class="updItem" id="${item.value.id}" value="${item.value.count}">
                                </label>
                            </td>
                            <td align="center">${item.value.totalPrice}</td>
                            <td align="center"><button class="deleteItem" onclick="location.href='CartServlet?action=delItem&id='+${item.value.id}">删除</button></td>
                        </tr>
                    </c:forEach>
                </table>
                <span>购物车中共有<span>${sessionScope.cart.totalCount}</span>件商品</span>
                <span>总共：<span>${sessionScope.cart.totalPrice}</span>元</span>
                <br/>
                <br/>
                <button class="clearCart" onclick="location.href='CartServlet?action=clearCart'">清空</button> |
                <button onclick="location.href='OrderServlet?action=createOrder'">结算</button> |
                <button onclick="location.href='CommodityServlet?action=searComs_mall'">返回</button>
            </c:if>
    </div>
</body>
</html>
