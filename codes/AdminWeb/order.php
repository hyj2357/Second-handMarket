<?php
	//检测是否登录，若没登录则转向登录界面  
    if(!isset($_SESSION['cid'])){
        header("Location:welcome.php");
        exit();
    }
?>
<html>
    <head>
        <title>订单与交易记录管理</title>
        <style>.error{color:#FF0000;}</style>
    </head>
    <body>
        <h3>修改订单</h3>
		<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
        需要修改的订单的ID（int）：<input type="text" name="oid">
                                   <span class="error">*<?php echo $oidErr;?></span><br>
        订单支付状态：<input type="radio" name="hasPay" value="0" />未支付<br />
                    <input type="radio" name="hasPay" value="1" />已支付<br />
        订单价格改为（float）：<input type="text" name="orderprice"><br>
                            <span class="error"><?php echo $orderpriceErr;?></span><br>
                   <input type="submit" name="submitOrder" value="提交">
        </form><br />

        <?php
            $oidErr = $orderpriceErr = "";
            function test_input($data) {
                $data = trim($data);
                $data = stripslashes($data);
                $data = htmlspecialchars($data);
                return $data;
            }
            
            if ($_SERVER["REQUEST_METHOD"] == "POST" && $_POST['submitOrder']) {
                
                if (empty($_POST["oid"])) {
                    $gidErr = "ID是必填的";
                    } else {
                        $oid = test_input($_POST["oid"]);
                        $oidErr = "";
                        // 检查ID是否有效
                        if (!filter_var($oid, FILTER_VALIDATE_INT)) {
                            $oidErr = "ID应为整数值"; 
                            $oid = NULL;
                        }
                }
                if (!empty($_POST["hasPay"])) {
                    $hasPay = $_POST["hasPay"];
                }
                if (!empty($_POST["orderprice"])) {
                    $orderprice = test_input($_POST["orderprice"]);
                    $orderpriceErr = "";
                    // 检查价格是否有效
                    if (!filter_var($orderprice, FILTER_VALIDATE_FLOAT)) {
                        $orderpriceErr = "价格应为浮点数"; 
                        $orderprice = NULL;
                        }
                }
                
                //包含数据库连接文件
                include('conn.php');
                
                if(!empty($oid)){
                    $result = mysql_query("
                        SELECT * 
                        FROM morder
                        WHERE oid = '$oid'");
                        $row = mysql_fetch_array($result);
                    if(empty($orderprice)) $price = $row['price'];
                    if(empty($hasPay)) $isOnline = $row['hasPay'];
                    
                    $sql = "UPDATE morder
                            SET price = '$orderprice', 
                                hasPay = '$hasPay' 
                            WHERE oid = '$oid'";
                    if(!mysql_query($sql,$con)){
                        die('Error：'.mysql_error());
                    }
                        echo "订单已修改成功";
                }
            }
        ?>
    </body>
</html>