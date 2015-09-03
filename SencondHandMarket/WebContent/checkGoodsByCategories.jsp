<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="utf-8"%>
<html>
<head>
<title>查找页面</title>
</head>
<body>

<form action="check_item_byClass" method="post">
    <table align="center">
    <caption><h3>check items by classes</h3></caption>
        <tr>
            <td>item class名：<input type="text" name="category"/></td>
        </tr>
        <tr align="center">
            <td colspan="2"><input type="submit" value="查询"/><input type="reset" value="重填" /></td>
        </tr>
    </table>
</form>
</body>
</html>
