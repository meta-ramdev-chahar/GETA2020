<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Student</title>
<style type="text/css">
	h1
	{	
		font-family: Georgia, 'Times New Roman', Times, serif;
		margin-left: 270px;
		font-size: 50px;
		color: red;
	}
	#mainDiv
	{
		margin-left: 400px;
		margin-top: 70px;
	}
	input[type = "submit"]
	{
		border-radius: 30px;
		width: 100px;
		height: 30px;
		margin-left: 30px;
		background-color: yellow;
	}
	input[type = "text"] 
	{
		border-radius: 30px;
		width: 300px;
		height: 30px;
		font-size: 20px;
		padding-left: 10px;
	}
</style>
</head>
<body>
<h1>Student Record System</h1>
<div id = "mainDiv">
	<form method = "get" action = "${pageContext.request.contextPath}/servlet3">
	<input type = "text" name = "name"><input type = "submit" value = "Search">
	</form>
</div>
</body>
</html>