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
<%-- 验证输出完整性 --%>
<script type="text/javascript">
    $(function (){
        $("#sub_btn").click(function (){
            //验证步骤
            //1.获取内容
            //2.创建正则表达式
            //3.比较验证

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
        })
    })

</script>
<body>
<h2>销售人员密码修改</h2>
<br/>
<p>当前密码为：${requestScope.sale.password}</p>
<br/>
<p>注：密码仅包含数字、字母、下划线，长度为5-12位</p>
<form action="UserServlet" method="post">
    <input type="hidden" name="action" value="updUserPass"/>
    <input type="hidden" name="id" value="${requestScope.sale.id}">

    <label>密码：</label>
    <label for="password">
        <input type="password" placeholder="字母数字下划线5-12位" autocomplete="off" tabindex="1" name="password"
               id="password"/>
    </label>
    <br/>
    <br/>

    <label>确认密码：</label>
    <label for="password">
        <input type="password" placeholder="与上述密码一致" autocomplete="off" tabindex="1" name="password2"
               id="password2"/>
    </label>
    <br/>
    <br/>

    <button id="sub_btn" type="submit" class="btn btn-default">Submit</button>
</form>
</body>
</html>
