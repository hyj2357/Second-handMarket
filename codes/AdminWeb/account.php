<?php
	//检测是否登录，若没登录则转向登录界面  
    if(!isset($_SESSION['cid'])){
        header("Location:welcome.php");
        exit();
    }
?>
<html>
    <head>
        <title>用户帐号管理</title>
        <style>.error{color:#FF0000;}</style>
    </head>
    <body>
        <h3>修改帐号信息</h3>
        <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
        需要修改信息的用户的ID：<input type="text" name="cid">
               <span class="error">*<?php echo $cidErr;?></span><br>
        名称改为：<input type="text" name="name"><br>
        密码改为：<input type="text" name="password"><br>
        所在省份改为：<input type="text" name="province"><br>
        所在城市改为：<input type="text" name="city"><br>
        所在地区改为：<input type="text" name="area"><br>
        手机号码改为：<input type="text" name="phonenumber"><br>
        用户权限改为：<input type="radio" name="authority" value="0" />普通用户注册申请等待通过<br />
                    <input type="radio" name="authority" value="1" />普通用户正常状态<br />
                    <input type="radio" name="authority" value="2" />普通用户封禁状态<br />
                    <input type="radio" name="authority" value="3" />普通管理员正常状态<br />
                    <input type="radio" name="authority" value="4" />普通管理员封禁状态<br />
                    <input type="radio" name="authority" value="5" />超级管理员权限<br />
                    <span class="error"><?php echo $authorityErr;?></span><br>
            <input type="submit" name="submit" value="提交">
        </form>
        <?php
            $cidErr = $authorityErr = "";
            function test_input($data) {
                $data = trim($data);
                $data = stripslashes($data);
                $data = htmlspecialchars($data);
                return $data;
            }
            
            if ($_SERVER["REQUEST_METHOD"] == "POST") {
                
                if (empty($_POST["cid"])) {
                    $cidErr = "ID是必填的";
                    } else {
                        $cid = test_input($_POST["cid"]);
                        $cidErr = "";
                        // 检查ID是否有效
                        if (!filter_var($cid, FILTER_VALIDATE_INT)) {
                            $cidErr = "ID应为整数值"; 
                            $cid = NULL;
                        }
                }
                if (!empty($_POST["name"])) {
                    $name = test_input($_POST["name"]);
                }
                if (!empty($_POST["password"])) {
                    $password = test_input($_POST["password"]);
                }
                if (!empty($_POST["province"])) {
                    $province = test_input($_POST["province"]);
                }
                if (!empty($_POST["city"])) {
                    $city = test_input($_POST["city"]);
                }
                if (!empty($_POST["area"])) {
                    $area = test_input($_POST["area"]);
                }
                if (!empty($_POST["school"])) {
                    $school = test_input($_POST["school"]);
                }
                if (!empty($_POST["phonenumber"])) {
                    $phonenumber = test_input($_POST["phonenumber"]);
                }
                if (!empty($_POST["authority"])) {
                    if($_SESSION['authority']<5 && $_POST['authority']>2){
                        $authorityErr = "权限不足";
                    } else {
                        $authority = $_POST['authority'];
                }
                    
                }
                
                //包含数据库连接文件
                include('conn.php');
                
                if(!empty($cid)){
                    $result = mysql_query("
                        SELECT * 
                        FROM customer 
                        WHERE cid = '$cid'");
                        $row = mysql_fetch_array($result);
                    if(empty($name)) $name = $row['name'];
                    if(empty($password)) $password = $row['password'];
                    if(empty($province)) $province = $row['province'];
                    if(empty($city)) $city = $row['city'];
                    if(empty($area)) $area = $row['area'];
                    if(empty($school)) $province = $row['school'];
                    if(empty($phonenumber)) $phonenumber = $row['phonenumber'];
                    if(empty($authority)) $authority = $row['authority'];
                    
                    $sql = "UPDATE customer
                            SET name = '$name',
                                password = '$password',
                                province = '$province',
                                city = '$city',
                                area = '$area',
                                school = '$school',
                                phonenumber = '$phonenumber',
                                authority = '$authority'
                            WHERE cid = '$cid'";
                    if(!mysql_query($sql,$con)){
                        die('Error：'.mysql_error());
                    }
                        echo "用户帐号信息已修改成功";
                }
            }
        ?>
    </body>
</html>