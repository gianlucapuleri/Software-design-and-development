<?php
$host = 'mysql';
$user = 'root';
$pass = 'rootpassword';
$conn = new mysqli($host, $user, $pass);
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

if ($conn->query("CREATE Database IF NOT EXISTS login") === FALSE) {
	die('Could not create database: ' . $conn->error);
}

$sql = 'DROP TABLE IF EXISTS user';
$conn->select_db('login');
if ($conn->query($sql) === FALSE) {
	die('Could not drop table user: ' . $conn->error);   
}
   
$sql = 'CREATE TABLE IF NOT EXISTS user( '.
      'name VARCHAR(20) NOT NULL, '.
      'password  VARCHAR(20) NOT NULL, '.
      'age   INT NOT NULL, '.
      'primary key ( name ))';
$conn->select_db('login');
if ($conn->query($sql) === FALSE) {
	die('Could not create table user: ' . $conn->error);   
}


$sql = 'INSERT INTO user '.
      '(name, password, age) '.
      'VALUES ( "gianluca", "puleri", 22 ) ,'.
	  '("gigi", "ciao", 18 ) ,'.
	  '("mario", "rossi", 38 )';      
$conn->select_db('login');
if ($conn->query($sql) === FALSE) {
	die('Could not enter data: ' . $conn->error);   
}
?>