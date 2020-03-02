<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="../includes/header.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
response.setHeader("Pragma","no-cache");
%>
<html>
<head>
	<title>Metacube Parking System</title>
<style>
	#currency 
	{
		visibility: hidden;
	}

	#home 
	{
		visibility: hidden;
	}
	#heading 
	{
		visibility: hidden;
	}
</style>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script>
        let id, user, x, ide;
        function curr2(clicked) 
        {
            ide = clicked;
        }
        function vehicleRegister() 
        {
            if (validate2() == true) 
            {
                var name = ide.value;
                document.getElementById('empRegisterationForm').style.display = 'none';
                document.getElementById('addVehicleForm').style.display = 'none';
                swal("2nd step completed", {icon: "success",});
                if (name == 'cycle')
                {
                    document.getElementById('cycleTable').style.visibility = 'visible';
                } 
                else if (name == 'bike') 
                {
                    document.getElementById('bikeTable').style.visibility = 'visible';
                }
            }
        }
        function ten(clicked) 
        {
          //  document.getElementById('cycleTable').style.visibility = 'hidden';
            document.getElementById('bikeTable').style.visibility = 'hidden';
            document.getElementById('currency').style.visibility = 'visible';
            id = clicked;
            document.getElementById('heading').style.visibility = 'visible';
        }
        function curr(value2) 
        {
            document.getElementById('currency').style.visibility = 'hidden';
            var va = document.getElementById(id).value;
            if (value2.value == 'usd') 
            {
                var val = va * 0.013;        
                document.getElementById('bikeTable').style.visibility = 'visible';
                document.getElementById('heading').style.visibility = 'hidden';
                document.getElementById('bikeTable').innerHTML = "<h1>Hey ! you are registered now.your cost is :" + val + "! </h1>";
                console.log(val);
            } 
            else if (value2.value == 'yen') 
            {
                var val = va * 1.54;    
                document.getElementById('bikeTable').style.visibility = 'visible';
                document.getElementById('heading').style.visibility = 'hidden';
                document.getElementById('bikeTable').innerHTML = "<h1>Hey ! you are registered now.your cost is :" + val + "! </h1>";
                console.log(val);
            }
            document.getElementById('home').style.visibility = 'visible';
        }
        function call()
        {
        	var name="xyz";
        	window.location.replace("price2.jsp?name="+name);	
        }
    </script>
</head>
<body>
	<table class="table table-striped" id=bikeTable>
		<thead>
			<tr>
				<th>Daily</th>
				<th>Monthly</th>
				<th>Yearly</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Rs.10<label> <input type="button"
						class="btn btn-primary" id="tena" value=10 onclick="ten(this.id)" /></label></td>
				<td>Rs.200 <label> <input type="button"
						class="btn btn-primary" id="threeHundreda" value=200
						onclick="ten(this.id)" /></label></td>
				<td>Rs.1000 <label> <input type="button"
						class="btn btn-primary" id="twelveHundreda" value=1000
						onclick="ten(this.id)" /></label></td>
			</tr>
		</tbody>
	</table>
	<div id="heading">
		<h2>Select Price</h2>
	</div>
	<div name="currency" id="currency">
		<select id="currMenu" name="currMenu" onchange="curr(this);">
			<option value="none" selected disabled hidden>Select currency</option>
			<option value="yen" id="yen">yen</option>
			<option value="usd" id="usd">usd</option>
		</select>
	</div>
	</div>
	<div name="home" id="home">
		<input type="button" value="PROCEED" class="btn btn-primary" onclick="window.location.href = '/employeeHome';">
	</div>
	<%
    String name=request.getParameter("name");
    if(name!=null)
    {
		response.sendRedirect("home.jsp");
    }
    %>
</body>
</html>