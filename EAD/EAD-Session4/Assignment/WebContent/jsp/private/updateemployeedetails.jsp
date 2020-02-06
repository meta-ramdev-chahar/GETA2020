<%@page import="dto.EmployeeDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
		EmployeeDTO employee = (EmployeeDTO) session.getAttribute("employeeDetail");
	%>
	<div id="EmployeeRegisterDiv">
		<h2 align="center">Employee Registration</h2>
		<form action="../../UpdateEmployeeDetailServlet" method="POST">
			<table align="center">
				<tr>
					<td><label><b>ID: </b></label></td>
					<td><input type="text" name="eid" id="name"
						value=<%out.print(employee.getId());%> readonly></td>
				</tr>
				<tr>
					<td><label><b>Name: </b></label></td>
					<td><input type="text" name="name" id="name"
						value=<%out.print(employee.getName()); %> pattern="([a-zA-Z ]+)"
						title="(should contain only alphabet's and minimum length should be 2)"
						minlength="2" required></td>
				</tr>
				<tr>
					<td><label><b>Gender: </b></label></td>
					<td>
						<%if(employee.getGender().equals("Male")){ %> <label> <input
							type="radio" name="gender" id="genderM" value="Male"
							<% out.print("checked");%>>Male
					</label> <label> <input type="radio" name="gender" id="genderF"
							value="Female">Female
					</label> <%} else { %> <label> <input type="radio" name="gender"
							id="genderM" value="Male">Male
					</label> <label> <input type="radio" name="gender" id="genderF"
							value="Female" <% out.print("checked"); %>>Female
					</label> <%}%>
					</td>
				</tr>
				<tr>
					<td><label><b>Email: </b></label></td>
					<td><input type="email" name="email" id="email"
						value=<%out.print(employee.getEmail());%> required></td>
				</tr>
				<tr>
					<td><label><b>Password: </b></label></td>
					<td><input type="password" name="password" id="password"
						value=<%out.print(employee.getPassword());%> pattern="[0-9]+"
						minlength="8"
						title="(should be minimum 8 character and should contain number)"
						required></td>
				</tr>
				<tr>
					<td><label><b>Confirm Password: </b></label></td>
					<td><input type="password" name="confirmpassword"
						id="confirmpassword" value=<%out.print(employee.getPassword());%>
						pattern="[0-9]+" minlength="8" title="(should be same as above)"
						required></td>
				</tr>
				<tr>
					<td><label><b>Contact Number: </b></label></td>
					<td><input type="text" name="contactnumber" id="contactnumber"
						value=<%out.print(employee.getPhoneNumber());%> pattern="[0-9]+"
						minlength="8"
						title="(should be numeric only and minimum 8 numbers" required>
					</td>
				</tr>
				<tr>
					<td><label><b>Organization : </b></label></td>
					<td><select name="organization">
							<option value="<% out.print(employee.getOrganization()); %>">
								<% out.print(employee.getOrganization()); %>
							</option>
							<option value="Metacube">Metacube</option>
							<option value="Infosys">Infosys</option>
							<option value="TCS">TCS</option>
							<option value="Google">Google</option>
					</select></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Register"></td>
				</tr>
			</table>
		</form>
	</div>
	<table>
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