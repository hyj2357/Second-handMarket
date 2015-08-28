<?php
	//检测是否登录，若没登录则转向登录界面  
    if(!isset($_SESSION['cid'])){
        header("Location:welcome.php");
        exit();
    }
?>
<html>
    <head>
        <title>商户管理</title>
        <style>.error{color:#FF0000;}</style>
    </head>
    <body>
        <h3>修改商品信息</h3>
		<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
        需要修改信息的商品的ID（int）：<input type="text" name="gid">
                                   <span class="error">*<?php echo $gidErr;?></span><br>
        商品价格改为（float）：<input type="text" name="price"><br>
                            <span class="error"><?php echo $priceErr;?></span><br>
        商品是否发布：<input type="radio" name="isOnline" value="0" />上线<br />
                    <input type="radio" name="isOnline" value="1" />下线<br />
        商品类别改为：<input type="text" name="category"><br>
        商品介绍改为：<textarea name="intro" rows="5" cols="40"></textarea>
                   <input type="submit" name="submitGood" value="提交">
        </form><br />
      //<h3>查看该商户发布的商品列表</h3>
        <form method="post" action="showList.php">
        该商户的ID（int）：<input type="text" name="cid">
                         <span class="error">*<?php echo $cidErr;?></span><br>
                         <input type="submit" name="showGood" value="查询">
        </form><br />
        <?php
            $gidErr = $priceErr = "";
            function test_input($data) {
                $data = trim($data);
                $data = stripslashes($data);
                $data = htmlspecialchars($data);
                return $data;
            }
            
            if ($_SERVER["REQUEST_METHOD"] == "POST" && $_POST['submitGood']) {
                
                if (empty($_POST["gid"])) {
                    $gidErr = "ID是必填的";
                    } else {
                        $gid = test_input($_POST["gid"]);
                        $gidErr = "";
                        // 检查ID是否有效
                        if (!filter_var($gid, FILTER_VALIDATE_INT)) {
                            $gidErr = "ID应为整数值"; 
                            $gid = NULL;
                        }
                }
                if (!empty($_POST["price"])) {
                    $price = test_input($_POST["price"]);
                    $priceErr = "";
                    // 检查价格是否有效
                    if (!filter_var($price, FILTER_VALIDATE_FLOAT)) {
                        $priceErr = "价格应为浮点数"; 
                        $price = NULL;
                        
                }
                if (!empty($_POST["isOnline"])) {
                    $isOnline = $_POST["isOnline"];
                }
                if (!empty($_POST["category"])) {
                    $category = test_input($_POST["category"]);
                }
                if (!empty($_POST["intro"])) {
                    $intro = test_input($_POST["intro"]);
                }
                
                }
                
                //包含数据库连接文件
                include('conn.php');
                
                if(!empty($gid)){
                    $result = mysql_query("
                        SELECT * 
                        FROM good 
                        WHERE gid = '$gid'");
                        $row = mysql_fetch_array($result);
                    if(empty($price)) $price = $row['price'];
                    if(empty($isOnline)) $isOnline = $row['isOnline'];
                    if(empty($category)) $category = $row['category'];
                    if(empty($intro)) $area = $row['intro'];
                    
                    $sql = "UPDATE good
                            SET price = '$price',
                                isOnline = '$isOnline',
                                category = '$categoty',
                                intro = '$intro' 
                            WHERE gid = '$gid'";
                    if(!mysql_query($sql,$con)){
                        die('Error：'.mysql_error());
                    }
                        echo "商品信息已修改成功";
                }
            }
        ?>
    </body>
</html>