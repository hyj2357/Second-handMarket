<%@ page language="java" contentType="text/html; charset=GBK"%>
<script src="prototype-1.6.0.2.js" type="text/javascript">
</script>
<script src="json2.js" type="text/javascript">
</script>
<script language="JavaScript">
	function gotClick()
	{
		//请求的地址
		var url = 'JSONExample.action';
		//将favorite表单域的值转换为请求参数
		var params = Form.serialize('form1');
		//创建Ajax.Request对象，对应于发送请求
		var myAjax = new Ajax.Request(
		url,
		{
			//请求方式：POST
			method:'post',
			//请求参数
			parameters:params,
			//指定回调函数
			onComplete: processResponse,
			//是否异步发送请求
			asynchronous:true
		});
	}
	function toClick(){
		var url = 'login';
		var params = Form.serialize('form1');
		var myAjax = new Ajax.Request(
		  url,{
			method:'get',
		    parameters:params,
			onComplete: processResponse,
			asynchronous:true
		}		
		)
		
	}
    function processResponse(request)
	{
		//使用JSON对象将服务器响应解析成JSON对象
		var res = JSON.parse(request.responseText);
		//遍历JSON对象的每个属性
		for(var propName in res)
		{
			$("show").innerHTML += propName + " --> " 
				+ res[propName] + "<br/>";
		}		
	}	
</script>
<html>
<head>
<title>使用JSON插件</title>
</head>
<body>
<form id="form1" name="form1" method="post">
name:<INPUT TYPE="text" name="name" id="name"/><br>
password:<INPUT TYPE="text" name="password" id="password"/><br>
<INPUT TYPE="button" value="提交" onClick="toClick();"/>
</form>
<div id="show">
</div>
</body>
</html>
