<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register your plan</title>
<script src="plan.js"></script>
</head>
<body>
	<% if(session.getAttribute("isPlanRegistered") != null) { %>
	<% response.sendRedirect("../../../ShowEmployeeDetailServlet");  %>
	<%} else { %>
	<div id="SelectPlanDiv">
		<br />
		<h2 align="center">Plan Selection</h2>
		<form id="planForm" action="../../../AddPlanServlet" method="post">
			<table align="center">
				<tr>
					<td><label id="vehicleType">
							<% out.print(session.getAttribute("vehicleType")); %>
					</label></td>
				</tr>
				<tr>
					<td colspan="3"><label><b>Currency: </b></label> 
					<select name="currencySelect" id="CurrencySelect" onchange="showCurrency()" required>
							<option value="INR">INR</option>
							<option value="USD">USD</option>
							<option value="YEN">YEN</option>
					</select></td>
				</tr>
				<tr>
					<td><label><b>Plan: </b></label></td>
				</tr>
				<tr>
					<td><label> <input type="radio" name="vehiclePlan"
							id="DailyPlan" value="Daily" required onclick="showTotal()">Daily
					</label></td>
					<td><label> <input type="radio" name="vehiclePlan"
							id="MonthlyPlan" value="Monthly" required onclick="showTotal()">Monthly
					</label></td>
					<td><label> <input type="radio" name="vehiclePlan"
							id="YearlyPlan" value="Yearly" required onclick="showTotal()">Yearly
					</label></td>
				</tr>
				<tr>
					<td id="costField"><label id="DailyCost"></label></td>
					<td id="costField"><label id="MonthlyCost"></label></td>
					<td id="costField"><label id="YearlyCost"></label></td>
				</tr>
				<tr>
					<td colspan="3"><label><b>Total Cost: </b></label> <input
						type="text" name="totalCost" id="TotalCost" readonly></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><input type="submit"
						value="Register Plan"></td>
				</tr>
			</table>
		</form>
	</div>
	<%} %>

</body>
</html>