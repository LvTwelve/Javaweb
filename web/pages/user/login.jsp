<%--
  Created by IntelliJ IDEA.
  User: 拾贰
  Date: 2020/11/9
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Store Of LvTwelve</title>

    <%@ include file="/pages/basic/head.jsp" %>


</head>

<body>
<div>
    <h2>登录</h2>
    <br/>
    <br/>
</div>
<div>
    <form action="UserServlet" method="post">
        <input type="hidden" name="action" value="login"/>

        <label>账号：</label>
        <label for="username">
            <input type="text"  autocomplete="off" tabindex="1" name="username"
                   value="${requestScope.username}"
                   id="username"/>
        </label>
        <br/>
        <br/>

        <label>密码：</label>
        <label for="password">
            <input type="password"  autocomplete="off" tabindex="1" name="password"
                   id="password"/>
        </label>
        <br/>
        <br/>
        <span >
            ${ empty requestScope.msg ? "请输入用户名和密码":requestScope.msg }
        </span>
        <br/>
        <br/>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>

</body>
</html>
