<%@page import="dto.EmployeeDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Home</title>
</head>
<body>
	<ul>
		<li>
			<a href="../index.jsp">Home</a>
		</li>
		<% if(session.getAttribute("email") != null) {%>
		<li>
			<a href="../../LogoutServlet">Logout</a>
		</li>
		<%} %>
	</ul>
	<%
		EmployeeDTO employee = (EmployeeDTO) session
				.getAttribute("employeeDetail");
	%>
	<h1 align="center">
		Welcome
		<%=employee.getName()%>
	</h1>
	<table align="center" border="thick">
		<tr>
			<td><label>Employee ID :</label></td>
			<td><label> <%
 	out.print(employee.getId());
 %>
			</label></td>
		</tr>
		<tr>
			<td><label>Employee Name :</label></td>
			<td><label> <%
 	out.print(employee.getName());
 %>
			</label></td>
		</tr>
		<tr>
			<td><label>Gender :</label></td>
			<td><label> <%
 	out.print(employee.getGender());
 %>
			</label></td>
		</tr>
		<tr>
			<td><label>Email :</label></td>
			<td><label> <%
 	out.print(employee.getEmail());
 %>
			</label></td>
		</tr>
		<tr>
			<td><label>Phone :</label></td>
			<td><label> <%
 	out.print(employee.getPhoneNumber());
 %>
			</label></td>
		</tr>
		<tr>
			<td><label>Organization :</label></td>
			<td><label> <%
 	out.print(employee.getOrganization());
 %>
			</label></td>
		</tr>
		<tr>
			<td align="left"><a href="../../RedirectToEditPage">Edit</a>
			</td>
			<td colspan="2" align="right"><a href="../../RedirectToShowFriendsPage">Your Friends</a>
			</td>
		</tr>
		<%
			if (session.getAttribute("error") != null) {
		%>
		<tr>
			<td align="center" colspan="2"><label style="color: red"><%=session.getAttribute("error")%></label>
			</td>
		</tr>
		<%
			session.removeAttribute("error");
			}
		%>
		<%
			if (session.getAttribute("message") != null) {
		%>
		<tr>
			<td align="center" colspan="2"><label style="color: green"><%=session.getAttribute("message")%></label>
			</td>
		</tr>
		<%
			session.removeAttribute("message");
			}
		%>
	</table>
</body>
</html>