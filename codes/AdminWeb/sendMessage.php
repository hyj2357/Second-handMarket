<?php
	//检测是否登录，若没登录则转向登录界面  
    if(!isset($_SESSION['cid'])){
        header("Location:welcome.php");
        exit();
    }
?>
<html>
    <head>
        <title>发送消息</title>
        <style>.error{color:#FF0000;}</style>
    </head>
    <body>
        <p><span class="error">* 必填</span></p>
        <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
            消息标题：<input type="text" name="title">
                    <span class="error">*<?php echo $titleErr;?></span><br>
            消息接收方ID：<input type="text" name="receiver">
                        <span class="error">*<?php echo $receiverErr;?></span><br>
            消息内容：<textarea name="content" rows="5" cols="40"></textarea>
                    <span class="error">*<?php echo $contentErr;?></span><br>
            <input type="submit" name="submit" value="提交">
        </form>
        <?php
            function test_input($data) {
                $data = trim($data);
                $data = stripslashes($data);
                $data = htmlspecialchars($data);
                return $data;
            }
            
            //定义变量并设置为空值
            $titleErr = $receiverErr = "";
            
            if ($_SERVER["REQUEST_METHOD"] == "POST") {
                
                if (empty($_POST["title"])) {
                    $titleErr = "标题是必填的";
                    } else {
                        $title = test_input($_POST["title"]);
                }
                
                if (empty($_POST["receiver"])) {
                    $receiverErr = "接收方是必填的";
                    } else {
                        $receiver = test_input($_POST["receiver"]);
                        // 检查ID是否有效
                        if (!filter_var($receiver, FILTER_VALIDATE_INT)) {
                            $receiverErr = "ID应为整数值"; 
                        }
                }
                
                if (empty($_POST["content"])) {
                    $content = " ";
                    } else {
                        $content = test_input($_POST["content"]);
                }
            
                if(!empty($title)&&!empty($receiver)&&!empty($content)){
                    //包含数据库连接文件
                    include('conn.php');
                    $sql = 
                    "INSERT INTO message(title,content,mstime,sender,receiver)
                    VALUES（'$title','$content','date('Y-m-d h:i:s')','{$_SESSION['cid']}','$receiver')";
                    if(!mysql_query($sql,$con)){
                        die('Error：'.mysql_error());
                    }
                    echo "消息已发送";
                    $title = $receiver =$content = NULL;
                }
            }
            
        ?>
    </body>
</html>