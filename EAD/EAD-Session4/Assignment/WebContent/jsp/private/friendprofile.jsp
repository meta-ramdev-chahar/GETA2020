<%@page import="dto.EmployeeDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Friend Profile</title>
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
	<%EmployeeDTO friend = (EmployeeDTO)session.getAttribute("friendDetail");%>
	<h1 align="center"><%=friend.getName()%>'s Profile
	</h1>
	<table align="center" border="thick">
		<tr>
			<td><label>Employee ID :</label></td>
			<td><label> <% out.print(friend.getId()); %>
			</label></td>
		</tr>
		<tr>
			<td><label>Employee Name :</label></td>
			<td><label> <% out.print(friend.getName()); %>
			</label></td>
		</tr>
		<tr>
			<td><label>Gender :</label></td>
			<td><label> <% out.print(friend.getGender()); %>
			</label></td>
		</tr>
		<tr>
			<td><label>Email :</label></td>
			<td><label> <% out.print(friend.getEmail());%>
			</label></td>
		</tr>
		<tr>
			<td><label>Phone :</label></td>
			<td><label> <% out.print(friend.getPhoneNumber()); %>
			</label></td>
		</tr>
		<tr>
			<td><label>Organization :</label></td>
			<td><label> <% out.print(friend.getOrganization()); %>
			</label></td>
		</tr>
		<%if(session.getAttribute("error") != null){ %>
		<tr>
			<td align="center" colspan="2"><label style="color: red"><%=session.getAttribute("error") %></label>
			</td>
		</tr>
		<%
				session.removeAttribute("error");
				} %>
		<%if(session.getAttribute("message") != null){ %>
		<tr>
			<td align="center" colspan="2"><label style="color: green"><%=session.getAttribute("message") %></label>
			</td>
		</tr>
		<%
				session.removeAttribute("message");
			} %>
	</table>
</body>
</html>