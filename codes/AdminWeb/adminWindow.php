<?php
	//检测是否登录，若没登录则转向登录界面  
    if(!isset($_SESSION['cid'])){
        header("Location:welcome.php");
        exit();
    }
?>
<html>
    <head>
        <title>TF4 SecondHandMarket Admin</title>
    </head>
    <body>
        <h2>TF4 SecondHandMarket Admin</h2><br />
        <p>AdminID:<?php echo $_SESSION['cid'];?>
           AdminName:<?php echo $_SESSION['name'];?>
           AdminType:<?php if($_SESSION['authority']==3){echo '普通管理员';}
                           else{echo '超级管理员';}?>
           <a href = "turner.php?action=logout">注销</a>
        </p><br />
        <table border = "1">
            <tr>
                <th><a href = "sendMessage.php" target = "_blank">发送消息</a></th>
                <th><a href = "account.php" target = "_blank">用户帐号管理</a></th>
                <th><a href = "good.php" target = "_blank">商品管理</a></th>
                <th><a href = "order.php" target = "_blank">订单与交易记录管理</a></th>
            </tr>
         </table>
         <br /><hr><br />
         <?php
             //包含数据库连接文件
             include('conn.php');
             
             $result = mysql_query("
                 SELECT * 
                 FROM message 
                 INNER JOIN customer 
                 ON message.receiver = customer.cid 
                 WHERE customer.authority > 2 
                 limit 20");
             
             while($row = mysql_fetch_array($result)){
                 
                 echo "消息ID：".$row['mid'];
                 echo "消息标题：".$row['title'];
                 
                 $senderAuthority = mysql_query("
                     SELECT authority
                     FROM customer
                     WHERE cid = {$row['sender']}");
                 switch($senderAuthority){
                     case 1:
                     case 2:echo "消息来自用户";
                     break;
                     case 3:
                     case 4:echo "消息来自普通管理员";
                     break;
                     case 5:echo "消息来自超级管理员";
                 }
                 
                 echo "消息发送方ID：".$row['sender'];
                 echo "消息接收方ID：".$row['receiver'];
                 echo "消息发送时间：".$row['mstime']."<br />";
                 echo "消息内容：".$row['content']."<br /><hr><br />";
             }
         ?>
    </body>
</html>