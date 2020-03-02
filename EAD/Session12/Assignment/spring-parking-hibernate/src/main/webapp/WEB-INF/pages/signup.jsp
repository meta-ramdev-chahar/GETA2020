<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="../includes/header2.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/signup" var="userActionUrl" />

<form:form modelAttribute="employee" action="${userActionUrl}">
	<form:errors />
	<form:hidden path="id" />
	<div class="form-group">
		<form:label path="username">Username</form:label>
		<form:input path="username" type="text" class="form-control"
			id="exampleInputUsername1" placeholder="Username" />
		<form:errors path="username" cssClass="text-danger" />
	</div>
	<div class="form-group">
		<form:label path="email">Email address</form:label>
		<form:input path="email" type="text" class="form-control"
			id="exampleInputEmail1" placeholder="Email" />
		<form:errors path="email" cssClass="text-danger" />
	</div>
	<div class="form-group">
		<form:label path="password">Password</form:label>
		<form:input path="password" type="password" class="form-control"
			id="exampleInputPassword1" placeholder="Password" />
		<form:errors path="password" cssClass="text-danger" />
	</div>
<%-- 	<div class="form-group">
		<form:label >Confirm Password</form:label>
		<form:input path="cpassword" type="password" class="form-control"
			id="exampleInputCpassword1" placeholder="Confirm Password" />
		<form:errors path="cpassword" cssClass="text-danger" />
	</div> --%>
	<div class="form-group">
		<form:label path="contactNo">Contact no</form:label>
		<form:input path="contactNo" type="text" class="form-control"
			id="exampleInputConno1" placeholder="Contact No" />
		<form:errors path="contactNo" cssClass="text-danger" />
	</div>
	<div class="form-group">
		<form:label path="organization">Organisation</form:label>
		<form:input path="organization" type="text" class="form-control"
			id="exampleInputOrg1" placeholder="Organisation" />
		<form:errors path="organization" cssClass="text-danger" />
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>
</form:form>
<%@include file="../includes/footer.jsp"%>