<%--
  Created by IntelliJ IDEA.
  User: 拾贰
  Date: 2020/11/16
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Store Of LvTwelve</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ include file="/pages/basic/head.jsp"%>
</head>
<body>
<form action="UserServlet" method="post">
    <input type="hidden" name="action" value="regist"/>

    <label>名称：</label>
    <label for="username">
        <input type="text" placeholder="请输入用户名称" autocomplete="off" tabindex="1" name="username"
               value="${requestScope.username}"
               id="username"/>
    </label>
    <br/>
    <br/>

    <label>密码：</label>
    <label for="password">
        <input type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password"
               id="password"/>
    </label>
    <br/>
    <br/>

    <label>确认密码：</label>
    <label for="password2">
        <input type="password" placeholder="请再次输入密码" autocomplete="off" tabindex="1" name="password2"
               id="password2"/>
    </label>
    <br/>
    <br/>

    <label>电子邮件：</label>
    <label for="email">
        <input type="text" placeholder="请输入电子邮件地址" autocomplete="off" tabindex="1" name="email"
               value="${requestScope.email}"
               id="email"/>
    </label>
    <br/>

    <span class="errorMsg">
        ${ requestScope.msg }
    </span>

    <br/>
    <input type="submit" value="注册" id="sub_btn"/>
</form>
</body>
</html>
