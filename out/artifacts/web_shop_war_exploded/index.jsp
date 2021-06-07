<%--
  Created by IntelliJ IDEA.
  User: 拾贰
  Date: 2020/11/9
  Time: 19:35
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

  <div>
    <br/>
    <br/>
    <br/><br/>
    <br/>
    <br/><br/>
    <br/>
    <br/>
      <h1 style="text-align:center" >这里，应有尽有。</h1>
      <br/>
      <br/>
    <br/>
    <br/>
    <br/>
    <br/>
      <p style="text-align:center"><button  type="button" class="btn btn-default" onclick="location.href='CommodityServlet?action=searComs_mall'" >开始购物</button></p>
<%--    <h2>这里，应有尽有。</h2>--%>
<%--    <form action="CommodityServlet" method="post">--%>
<%--        <input type="hidden" name="action" value="searComs_mall"/>--%>
<%--        <button type="submit">开始购物</button>--%>
<%--    </form>--%>
  </div>

  </body>
</html>
