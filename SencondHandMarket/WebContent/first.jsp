<%@ page language="java" contentType="text/html; charset=GBK"%>
<script src="prototype-1.6.0.2.js" type="text/javascript">
</script>
<script src="json2.js" type="text/javascript">
</script>
<script language="JavaScript">
	function gotClick()
	{
		//����ĵ�ַ
		var url = 'JSONExample.action';
		//��favorite�����ֵת��Ϊ�������
		var params = Form.serialize('form1');
		//����Ajax.Request���󣬶�Ӧ�ڷ�������
		var myAjax = new Ajax.Request(
		url,
		{
			//����ʽ��POST
			method:'post',
			//�������
			parameters:params,
			//ָ���ص�����
			onComplete: processResponse,
			//�Ƿ��첽��������
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
		//ʹ��JSON���󽫷�������Ӧ������JSON����
		var res = JSON.parse(request.responseText);
		//����JSON�����ÿ������
		for(var propName in res)
		{
			$("show").innerHTML += propName + " --> " 
				+ res[propName] + "<br/>";
		}		
	}	
</script>
<html>
<head>
<title>ʹ��JSON���</title>
</head>
<body>
<form id="form1" name="form1" method="post">
name:<INPUT TYPE="text" name="name" id="name"/><br>
password:<INPUT TYPE="text" name="password" id="password"/><br>
<INPUT TYPE="button" value="�ύ" onClick="toClick();"/>
</form>
<div id="show">
</div>
</body>
</html>
