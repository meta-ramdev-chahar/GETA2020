<%@ page language="java" contentType="text/html; charset =U TF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
</head>
<body>
	<% if (session.getAttribute("email") != null){ %>
	<% 
   response.sendRedirect("../ShowEmployeeDetailServlet");
 %>
	<%} else { %>
	<%if(session.getAttribute("message")!= null){ %>
	<h3 style="color: green" align="center"><%=session.getAttribute("message") %></h3>
	<%session.removeAttribute("message");%>
	<%} %>
	<%if(session.getAttribute("error")!= null){ %>
	<h3 style="color: red" align="center"><%=session.getAttribute("error") %></h3>
	<%session.removeAttribute("error");%>
	<%} %>
	<div id="EmployeeRegisterDiv">
		<h2 align="center">Employee Registration</h2>
		<form action="../AddEmployeeServlet" method="POST">
			<table align="center">
				<tr>
					<td><label><b>Name: </b></label></td>
					<td><input type="text" name="name" id="name"
						placeholder="Enter your name" pattern="([a-zA-Z ]+)"
						title="(should contain only alphabet's and minimum length should be 2)"
						minlength="2" required></td>
				</tr>
				<tr>
					<td><label><b>Gender: </b></label></td>
					<td><label> <input type="radio" name="gender"
							id="genderM" value="Male" required>Male
					</label> <label> <input type="radio" name="gender" id="genderF"
							value="Female" required>Female
					</label></td>
				</tr>
				<tr>
					<td><label><b>Email: </b></label></td>
					<td><input type="email" name="email" id="email"
						placeholder="Enter your email" required></td>
				</tr>
				<tr>
					<td><label><b>Password: </b></label></td>
					<td><input type="password" name="password" id="password"
						placeholder="Enter your password" pattern="[0-9]+" minlength="8"
						title="(should be minimum 8 character and should contain number)"
						required></td>
				</tr>
				<tr>
					<td><label><b>Confirm Password: </b></label></td>
					<td><input type="password" name="confirmpassword"
						id="confirmpassword" placeholder="Enter same password again"
						pattern="[0-9]+" minlength="8" title="(should be same as above)"
						required></td>
				</tr>
				<tr>
					<td><label><b>Contact Number: </b></label></td>
					<td><input type="text" name="contactnumber" id="contactnumber"
						placeholder="Enter your contact number" pattern="[0-9]+"
						minlength="8"
						title="(should be numeric only and minimum 8 numbers" required>
					</td>
				</tr>
				<tr>
					<td><label><b>Organization : </b></label></td>
					<td><select name="organization">
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
	<% } %>
</body>
</html>