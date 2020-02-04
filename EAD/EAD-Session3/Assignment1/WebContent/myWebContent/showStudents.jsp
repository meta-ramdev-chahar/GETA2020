<%@page import="java.util.HashSet"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>show all students</title>
	<style type="text/css">
        h1
		{	
			font-family: Georgia, 'Times New Roman', Times, serif;
			margin-left: 270px;
			font-size: 50px;
			color: red;
		}
		input[type="submit"] 
		{
			color: red;
			background: white;
			margin-bottom: 4px;
		}
		td
		{
			padding-top: 4px;
		}
		table
		{
			
		}
		#mainDiv
		{
			margin-left: 140px;
		}
		select
		{
			width: 150px;	
		}
		#allClassDiv
		{
			margin-right: 160px;
		}
	</style>
</head>
<body>
	<h1>Student Record System</h1>
	<%
		ResultSet rs = (ResultSet) request.getAttribute("students");
		String callingServlet = (String) request
				.getAttribute("callingServlet");
		HashSet<String> allClasses = new HashSet<String>();
		if (callingServlet != null) {

			while (rs.next()) {
				allClasses.add(rs.getString(6));
			}
			rs.beforeFirst();
		}
	%>
<div id = "mainDiv">
<div id = "allClassDiv" align = "right">
		<form action="servlet6" method="get">
			<select name = "classOfStudent" id = "classOfStudent" required>
			  <option value="">Filter By class</option>
			<%
				for (String s : allClasses) {
			%>
               <option value=<%out.print(s);%>>&#160; <%out.print(s);%> </option>            
             <%
				}
			 %>
			 </select>
             <label><input type="submit" id="but" value=Filter></label>
		</form>
</div>
  <div id = "tableDiv">
	<table border="thick">
		<col width="90">
  		<col width="90">
  		<col width="90">
  		<col width="130">
  		<col width="170">
  		<col width="90">
  		<col width="90">
  		<col width="50">
  		<col width="50">
		<tr>
			<th>Student ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Father Name</th>
			<th>Email</th>
			<th>Class</th>
			<th>Age</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<%
			while (rs.next()) {
		%>
		<tr>
			<td>
				<%
					out.print(rs.getString(1));
				%>
			</td>
			<td>
				<%
					out.print(rs.getString(2));
				%>
			</td>
			<td>
				<%
					out.print(rs.getString(3));
				%>
			</td>
			<td>
				<%
					out.print(rs.getString(4));
				%>
			</td>
			<td>
				<%
					out.print(rs.getString(5));
				%>
			</td>
			<td>
				<%
					out.print(rs.getString(6));
				%>
			</td>
			<td>
				<%
					out.print(rs.getInt(7));
				%>
			</td>
			<td>
				<form action="servlet4" method="get">
					<input type="hidden" name="id" value=<%out.print(rs.getString(1));%>> 
					<input type="submit" value="Edit">
				</form>
			</td>
			<td>
				<form action="servlet5" method="get">
					<input type="hidden" name="id" value=<%out.print(rs.getString(1));%>> 
					<input type="submit" value="Delete">
				</form>
			</td>
		</tr>
		<%
			}
			rs.beforeFirst();
		%>
	</table>
 </div>
</div>

</body>
</html>