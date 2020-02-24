<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.io.File"%>
<%@page import="java.io.IOException"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.ByteArrayOutputStream"%>

<%@page import="java.math.BigInteger"%>
<%@page import="javax.xml.bind.DatatypeConverter"%>
<%@page import="java.awt.image.BufferedImage"%>

<%@include file="../includes/header.jsp"%>

<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
response.setHeader("Pragma","no-cache");
%>

<br>
<br>
<br>
<br>
<br>
<table class="table table-striped">
	<thead>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>ContactNo</th>
			<th>Organization</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${id}</td>
			<td>${empname}</td>
			<td>${email}</td>
			<td>${password}</td>
			<td>${contactNo}</td>
			<td>${organization}</td>
			<td><a href="/employees/${id}" class="btn btn-primary">Edit</a>&nbsp;</td>
		</tr>
	</tbody>
</table>
<%@include file="../includes/footer.jsp"%>
