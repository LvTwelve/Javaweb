<%--
  Created by IntelliJ IDEA.
  User: 拾贰
  Date: 2021/6/5
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Store Of LvTwelve</title>
    <%@ include file="/pages/basic/head.jsp" %>
</head>
<body>
<h2>销售人员级别修改</h2>
<br/>
<p>人员级别信息</p>
<br/>
<p>1 -- 管理员</p>
<p>2 -- 销售人员</p>
<p>3 -- 普通用户</p>
<br/>
<p>当前级别：${requestScope.sale.level}</p>
<br/>
<form action="UserServlet" method="post">
    <input type="hidden" name="action" value="updUserLevel"/>
    <input type="hidden" name="id" value="${requestScope.sale.id}">
    <p>
        请选择修改后的级别：
        <label>
            <select name="level">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
            </select>
        </label>
    </p>
    <button type="submit">提交</button>
</form>
</body>
</html>
