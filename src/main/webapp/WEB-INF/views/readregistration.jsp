<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read</title>
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
/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {background-color: #f2f2f2;}
</style>
</head>
<body>
<form action="readreg" method="post">
<div class="container">
    <h1> All Student Details</h1>
    <hr>

<table>
  <tr>
  <th>Name</th>
  <th>Father's name</th>
  <th>Mother's name</th>
  <th>Gender</th>
  <th>Email</th>
  <th>Mobile</th>
  <th>Course</th>
  </tr>
  <%
	ResultSet res = (ResultSet)request.getAttribute("res");
	while(res.next()){


 %><tr>
  <td><%=res.getString(1)%></td>
  <td><%=res.getString(2)%></td>
  <td><%=res.getString(3)%></td>
  <td><%=res.getString(4)%></td>
  <td><%=res.getString(5)%></td>
  <td><%=res.getString(6)%></td>
  <td><%=res.getString(7)%></td>
  </tr>
  
  <%}%>
  </table>
</div>
</form>

</body>
</html>