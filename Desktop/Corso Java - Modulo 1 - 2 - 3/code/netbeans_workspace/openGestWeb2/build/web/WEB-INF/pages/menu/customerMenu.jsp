<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<html>
	
		<head>
			<title>Open GEST</title>
		</head>
		<%String path = request.getContextPath();%>
		<div id="usermenu" class="left-float-component">
		  <ul id="menulink">
		        <li class="bordered-menu"><a href="<%=path%>/customers/list"><fmt:message key="label.message.header.list.customers.text"/></a></li>
		        <li class="bordered-menu"><a href="<%=path%>/customers/createinit"><fmt:message key="label.customers.menu.create.text"/></a></li>
		    </ul>
		</div>

</html>