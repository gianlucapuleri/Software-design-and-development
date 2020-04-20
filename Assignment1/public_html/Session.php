<?php
   include('config.php');
   session_start();
   
   $user_check = $_SESSION['login_user'];
   
   $ses_sql = $conn->query("select name, age from user where name = '$user_check' ");
   
   $row = $ses_sql->fetch_array(MYSQLI_ASSOC);
   
   $login_name = $row['name'];
   $login_age = $row['age'];
   
   if(!isset($_SESSION['login_user'])){
      header("location:index.php");
   }
?>