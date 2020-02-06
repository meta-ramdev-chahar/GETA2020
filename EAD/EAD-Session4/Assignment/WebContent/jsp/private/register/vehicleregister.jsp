<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register your vehicle</title>
</head>
<body>
	<% if(session.getAttribute("isVehicleRegistered") != null) { %>
	<% response.sendRedirect("../../../ShowEmployeeDetailServlet");  %>
	<%} else { %>
	<div id="VehicleRegisterDiv">
		<br />
		<h2 align="center">Vehicle Registration</h2>
		<form id="vehicleForm" action="../../../AddVehicleServlet"
			method="POST">
			<table align="center">
				<tr>
					<td><label><b>Vehicle Name: </b></label></td>
					<td><input type="text" name="vehicleName" id="EmpVehicleName"
						placeholder="Enter your vehicle name" pattern="[a-zA-Z]+"
						minlength="4" required></td>
				</tr>
				<tr>
					<td><label><b>Vehicle Type: </b></label></td>
					<td><select name="vehicleType" id="EmpVehicleType" required>
							<option value="Cycle">Cycle</option>
							<option value="MotorCycle">Motor Cycle</option>
							<option value="FourWheeler">Four Wheeler</option>
					</select></td>
				</tr>
				<tr>
					<td><label><b>Vehicle Number: </b></label></td>
					<td><input type="text" name="vehicleNumber"
						id="EmpVehicleNumber" placeholder="Enter your vehicle number"
						required></td>
				</tr>
				<tr>
					<td><label><b>Employee Id: </b></label></td>
					<td><input type="text" name="empId" id="EmpId"
						value="<% out.print(session.getAttribute("eid")); %>" readonly
						required></td>
				</tr>
				<tr>
					<td><label><b>Vehicle Identification: </b></label></td>
					<td><textarea name="identification"
							id="EmpVehicleIdentification" cols="20" rows="5"
							placeholder="Enter your vehicle identifications" required></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Add Vehicle"></td>
				</tr>
			</table>
		</form>
	</div>
	<%} %>
</body>
</html>