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
<title>Dojo</title>
</head>
<body>

	<h1>New Dojo</h1>
	
	<form:form action="/" method="post" modelAttribute="dojo">
		<div>
	        <form:label path="dojoName">Name: </form:label>
	        <form:errors path="dojoName"/>
	        <form:input path="dojoName"/>
	    </div>
	    <input type="submit" value="Create"/>
	</form:form>



</body>
</html>