<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@include file="../includes/header.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/vehicleRegister" var="userActionUrl" />

<form:form modelAttribute="veh" action="${userActionUrl}">
	<form:errors />
	<form:hidden path="vid" />
	<div class="form-group">
		<form:label path="vehname">vehname</form:label>
		<form:input path="vehname" type="text" class="form-control" id="exampleInputVehname1" placeholder="vehname" />
		<form:errors path="vehname" cssClass="text-danger" />
	</div>
	<div class="form-group">
		<form:label path="vid">vid</form:label>
		<form:input path="vid" type="text" class="form-control" id="exampleInputVid1" placeholder="vid" readonly="true" />
		<form:errors path="vid" cssClass="text-danger" />
	</div>
	<div class="form-group">
		<form:label path="vehtype">vehtype </form:label>
		<form:input path="vehtype" type="text" class="form-control" id="exampleInputVehtype" placeholder="vehtype " />
		<form:errors path="vehtype" cssClass="text-danger" />
	</div>
	<div class="form-group">
		<form:label path="vehno">vehno </form:label>
		<form:input path="vehno" type="text" class="form-control" id="exampleInputVehno1" placeholder="vehno " />
		<form:errors path="vehno" cssClass="text-danger" />
	</div>
	<button type="submit" class="btn btn-primary">Submit</button>
</form:form>
<%@include file="../includes/footer.jsp"%>