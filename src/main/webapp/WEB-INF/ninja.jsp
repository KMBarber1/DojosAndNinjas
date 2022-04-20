<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja</title>
</head>
<body>

	<h1>New Ninja</h1>
		
		<form:form action="/new/ninja" method="post" modelAttribute="ninja">
			<div>
		        <form:label path="dojo"></form:label>
		        <form:errors path="dojo"/>
     			<form:select path="dojo">
			        <c:forEach var="dojo" items="${allDojos}">
			        	<form:option value="${dojo.id}">
			        		<c:out value ="${dojo.dojoName}"/>
			        	</form:option>
		        	</c:forEach>
		        </form:select>
		    </div>

		    <div>
		        <form:label path="firstName">First Name:</form:label>
		        <form:errors path="firstName"/>
		        <form:input path="firstName"/>
		    </div>
		    
		    <div>
		        <form:label path="lastName">Last Name:</form:label>
		        <form:errors path="lastName"/>
		        <form:input path="lastName"/>
		    </div>
		    
		    <div>
		        <form:label path="age">Age:</form:label>
		        <form:errors path="age"/>
		        <form:input type="age" path="age"/>
		    </div>
		    
		    <input type="submit" value="Create"/>
		    
		</form:form>

</body>
</html>