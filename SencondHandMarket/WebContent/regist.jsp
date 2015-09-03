<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="utf-8"%>
<html>
<head>
<title>登录页面</title>
</head>
<body>

<form action="RegistUserAction" method="post">
    <table align="center">
    <caption><h3>用户注册</h3></caption>
        <tr>
            <td>用户名：<input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>密&nbsp;&nbsp;码：<input type="text" name="password"/></td>
        </tr>
        <tr>
            <td>学校&nbsp;&nbsp;：<input type="text" name="school"/></td>
        </tr>
        <tr>
            <td>电话号&nbsp;&nbsp;码：<input type="text" name="phonenumber"/></td>
        </tr>
        <tr>
            <td>QQ号&nbsp;&nbsp;码：<input type="text" name="qqnumber"/></td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="submit" value="登录"/><input type="reset" value="重填" /></td>
        </tr>
    </table>
    <%
         out.print(session.getAttribute("logged"));
     %>
</form>
</body>
</html>
