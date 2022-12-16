<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student</title>
<style>
body {
  font-size: 14px;
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
  position: -webkit-sticky; /* Safari */
  position: sticky;
  top: 0;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover {
  background-color: #111;
}


</style>
</head>
<body>
<ul>
  <li><a href="newreg">New Registration</a></li>
  <li><a href="readreg">All Students</a></li>
  <li><a href="deletereg">Delete Student Details</a></li>
  <li><a href="updatereg">Update Student Details</a></li>
  <li style="float:right"><a href="logout">Logout</a></li>
</ul>


</body>
</html>

