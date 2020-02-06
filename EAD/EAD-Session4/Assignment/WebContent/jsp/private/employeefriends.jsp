<%@page import="dto.EmployeeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Friends</title>
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
	<h1 align="center">Your Friend List</h1>
	<table align="center" border="thick">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Show Profile</th>
		</tr>
		<%
			String s;
			List<EmployeeDTO> friendList = (List) session
					.getAttribute("friendList");
			for (EmployeeDTO friend : friendList) {
		%>
		<tr>
			<td><label>
					<%
						out.print(friend.getId());
					%>
			</label></td>
			<td><label>
					<%
						out.print(friend.getName());
					%>
			</label></td>
			<td><label>
					<%
						out.print(friend.getEmail());
					%>
			</label></td>
			<td>
				<%
					s = "../../ShowFriendDetailServlet?email=" + friend.getEmail();
				%>
				<a href="<%out.print(s);%>">Show Profile</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>

	<table>
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