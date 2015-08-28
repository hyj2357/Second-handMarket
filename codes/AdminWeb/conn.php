<?php
	$conn = mysql_connect("127.0.0.1","root","psw5424364") or die("数据库链接错误".mysql_error());
	mysql_select_db("secondhandmarket",$conn) or die("数据库访问错误".mysql_error());
	mysql_query("set names gb2312");
?>