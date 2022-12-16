<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New</title>
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  text-align: center;
}

/* Add padding to containers */
.container {
  padding: 16px;
  background-color: white;
}

/* Full-width input fields */
input[type=text],input[type=email] ,select{
  width: 20%;
  padding: 10px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}
@media screen and (min-width: 768px) {
    form {
        display: inherit;
        flex-wrap: wrap;
        justify-content: space-between;
    }
 
    form div {
        width: 100%;
    }
  }

input[type=text]:focus {
  background-color: #ddd;
  outline: none;
  
}
/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.savebtn {
  background-color: #aa6d04;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 10%;
  opacity: 0.9;
}

.savebtn:hover {
  opacity: 1;
}


</style>
</head>
<body>

<form action="newreg" method="post">
  <div class="container">
    <h1> New Student Registration </h1>
    <hr>

    <label for="name"><b>Student Name</b></label>
    <input type="text" placeholder="Enter Fullname" name="name" id="name" required>
    <br>
     <label for="fname"><b>Father's Name</b></label>
    <input type="text" placeholder="Enter Fullname" name="fname" id="fname" required>
     <br>
     <label for="mname"><b>Mother's Name</b></label>
    <input type="text" placeholder="Enter Fullname" name="mname" id="mname" required>
	 <br>
	<label for="gender"><b>Gender</b></label>
    <select id="gender" name="gender">
      <option value="Male">Male</option>
      <option value="Female">Female</option>
      <option value="Other">Other</option>
    </select>
     <br>
    <label for="email"><b>Email</b></label>
    <input type="email" placeholder="Enter Email" name="email" id="email" required>
     <br>
    <label for="mobile"><b>Mobile Number</b></label>
    <input type="text" placeholder="Enter Mobile Number" name="mobile" id="mobile" required>
     <br>
	<label for="course"><b>Course</b></label>
    <input type="text" placeholder="Enter Course name" name="course" id="course" required>
     <br>
      <button type="submit" class="savebtn">Save</button>
  </div>
 
</form>
<%
if(request.getAttribute("msg")!=null){
	out.println(request.getAttribute("msg"));
}
%>
</body>
</html>