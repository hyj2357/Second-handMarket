<!DOCTYPE HTML>
<html>
    <body> 
<?php
    //输入处理
    function test_input($data) {
        $data = trim($data);
        $data = stripslashes($data);
        $data = htmlspecialchars($data);
        return $data;
    }
    //接收表单信息
    if(!isset($_POST['submit'])){
        exit('非法访问');
    }
    //检查表单信息
    if (empty($_POST["cid"])) {
     exit('ID不能为空');
   } else {
     $cid = test_input($_POST["cid"]);
     // 检查ID是否为int值
     if (!filter_var($cid, FILTER_VALIDATE_INT)) {
       exit('ID只允许整形数字');
     }
   }
    if(empty($_POST['name'])){
        exit('姓名不能为空');
    } else {
        $name = test_input($_POST['name']);
    }
    if(empty($_POST['password'])){
        exit('密码不能为空');
    } else {
        $password = test_input($_POST['password']);
    }
    //包含数据库连接文件
    include('conn.php');  
    //SQL查询，检测ID、用户名、密码是否正确
    $check_query = mysql_query("SELECT * FROM customer WHERE cid=$cid and name='{$name}' and password='{$password}' limit 1");
    if($result = mysql_fetch_array($check_query)){
        switch($result['authority']){
            //普通管理员登录成功
            case 3:
            session_start();
            $_SESSION['cid'] = $result['cid'];
            $_SESSION['name'] = $result['name'];
            $_SESSION['authority'] = $result['authority'];
            echo $name,' 欢迎进入普通管理员系统 <a href="adminWindow.php"></a><br />';
            echo '点击此处 <a href="turner.php?action=logout">注销</a><br />';
            exit;
            break;
            //超级管理员登陆成功
            case 5:
            session_start();
            $_SESSION['cid'] = $result['cid'];
            $_SESSION['name'] = $result['name'];
            $_SESSION['authority'] = $result['authority'];
            echo $name,' 欢迎进入超级管理员系统 <a href="adminWindow.php"></a><br />';
            echo '点击此处 <a href="turner.php?action=logout">注销</a><br />';
            exit;
            break;
            //没有权限，登陆失败
            default:
            echo '权限不足';
            exit;
        }
    }else{
            exit('登录失败！点击此处 <a href="javascript:history.back(-1);">返回</a> 重试');
    }
    //注销登录
    if($_GET['action'] == "logout"){
        unset($_SESSION['cid']);
        unset($_SESSION['name']);
        unset($_SESSION['authority']);
        echo '注销成功！点击此处 <a href="welcome.php">登录</a>';
        exit;
}
?>
</body>
</html>