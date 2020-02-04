
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new Student</title>
	<style type="text/css">
		td
        {
            width : 200px;
            padding-top : 10px;
        }
        input
        {
            border-style : groove;
            border-radius : 30px;
            padding : 5px;            
        }
        #inputForm
        {
        	border-style : groove;
        	border-radius : 30px;
        	width: 450px;
        	padding-left: 60px;
        	margin-left: 300px;
        	margin-top: 30px;
        	padding-bottom: 20px;
        }
        h1
		{	
			font-family: Georgia, 'Times New Roman', Times, serif;
			margin-left: 290px;
			font-size: 50px;
			color: red;
		}
		input[type="submit"] 
		{
			color: red;
	
		}
	</style>
</head>
<body>
<h1>Student Record System</h1>
<div id = "inputForm">
	<form action = "${pageContext.request.contextPath}/servlet1" method = post>
		<table>
			<tr>
				<td>
					<label>	First Name : </label>
				</td>
				<td>
					<label><input type = "text" name = "firstName" required ></label>
				</td>
			</tr>
			<tr>
				<td>
					<label>Last Name :</label>
				</td>
				<td>
					<label><input type = "text" name = "lastName"  required></label>
				</td>
			</tr>
			<tr>
				<td>
					<label>Father Name :</label>
				</td>
				<td>
					<label><input type = "text" name = "fatherName" required ></label>
				</td>
			</tr>
			<tr>
				<td>
					<label>Email :</label>
				</td>
				<td>
					<label><input type = "email" name = "email" required></label>
				</td>
			</tr>
			<tr>
				<td>
					<label>Class :</label>
				</td>
				<td>
					<label><input type = "text" name = "class" required></label>
				</td>
			</tr>
			<tr>
				<td>
					<label>Age :</label>
				</td>
				<td>
					<label><input type = "number" name = "age" required ></label>
				</td>
			</tr>
			<tr>
				<td>
				</td>
				<td>
					<label><input type = "submit" value = "Add student"></label>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>