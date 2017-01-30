<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
	
		<head>
			<%String path = request.getContextPath();%>
			<title>Open GEST</title>
			<link rel="stylesheet" type="text/css" href="<%=path%>/resources/styles/menu.css"/>
		</head>
		<div id="topmenu">
		  <ul id="subtabs">
		        <li id="activelink" class="bordered-menu"><a href="#"><fmt:message key="label.menu.principal.home.text"/></a></li>
		        <li class="bordered-menu"><a href="<%=path%>/usersMenu"><fmt:message key="label.menu.principal.users.text"/></a></li>
		        <li class="bordered-menu"><a href="<%=path%>/customersMenu"><fmt:message key="label.menu.principal.customers.text"/></a></li>
		        <li class="bordered-menu"><a href="<%=path%>/ordersMenu"> <fmt:message key="label.menu.principal.orders.text"/></a></li>
		        <li class="bordered-menu"><a href="<%=path%>/productsMenu"><fmt:message key="label.menu.principal.werehouse.text"/></a></li>
		    </ul>
		</div>
		<div class="global-error-messagge">
			<c:out value="${errorMSG}"></c:out>
		</div>
</html>