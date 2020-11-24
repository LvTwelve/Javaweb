<%--
  Created by IntelliJ IDEA.
  User: 拾贰
  Date: 2020/11/16
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Store Of LvTwelve</title>

    <%@ include file="/pages/basic/head.jsp" %>

    <%-- 验证输出完整性 --%>
    <script type="text/javascript">
        $(function (){
            $("#sub_btn").click(function (){
                //验证步骤
                //1.获取内容
                //2.创建正则表达式
                //3.比较验证

                //名称 -- 由字母，数字下划线组成，并且长度为5到12位
                let usernameTxt = $('#username').val();
                let usernamePat = /^\w{5,12}$/;
                if(usernamePat.test(usernameTxt) === false){
                    alert("用户名不合法！");
                    return false;
                }

                //密码 -- 由字母，数字下划线组成，并且长度为5到12位
                let passwordTxt = $('#password').val();
                let passwordPat = /^\w{5,12}$/;
                if(passwordPat.test(passwordTxt) === false){
                    alert("密码不合法！");
                    return false;
                }

                //确认密码 -- 与密码一致
                let password2Txt = $('#password2').val();
                if(password2Txt !== passwordTxt){
                    alert("密码不一致！");
                    return false;
                }

                //邮箱 -- xxxxx@xxx.com
                let emailTxt = $('#email').val();
                let emailPat= /^([a-zA-Z]|[0-9])(\w)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
                if(emailPat.test(emailTxt) === false){
                    alert("邮箱不合法！");
                    return false;
                }
            })
        })

    </script>
</head>
<body>
<div>
    <h2>注册</h2>
    <br/>
    <br/>
</div>

<div>
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
        <label for="password">
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
        <br/>

        <span class="errorMsg">
            ${ requestScope.msg }
        </span>

        <br/>
        <button id="sub_btn" type="submit" class="btn btn-default">Submit</button>
    </form>
</div>
</body>
</html>
