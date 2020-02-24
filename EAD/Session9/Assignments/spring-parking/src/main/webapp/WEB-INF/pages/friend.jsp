<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../includes/header.jsp"%>

<%
	response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
	response.setHeader("Pragma","no-cache");
%>
<table class="table table-striped">
	<thead>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Email</th>
			<th>Organization</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${employee2}" var="employee">
			<tr>
				<td>${employee.id}</td>
				<td>${employee.username}</td>
				<td>${employee.email}</td>
				<td>${employee.organization}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<%@include file="../includes/footer.jsp"%>

