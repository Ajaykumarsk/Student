<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
form {text-align: center;}

input[type=text], input[type=password] {
  width: 30%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;

}

button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 10%;
  
}

button:hover {
  opacity: 0.8;
}


.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  width: 5%;
  border-radius: 5%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}
h2 {text-align: center;}

}
</style>
</head>
<body >

<h2>Login Form</h2>

<form action="logfrom" method="post">
  <div class="imgcontainer">
    <img src="img_avatar2.png" alt="Avatar" class="avatar">
  </div>

  <div class="container">
    <label for="email"><b>Username </b></label>
    <input type="text" placeholder="Enter Username" name="email" required>
	<br>
    <label for="psw"><b>Password </b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>
        <br>
    <button type="submit">Login</button>
  </div>
  <%
	if(request.getAttribute("Error")!=null){
		out.println(request.getAttribute("Error"));
	}
	%>
</form>
</body>
</html>