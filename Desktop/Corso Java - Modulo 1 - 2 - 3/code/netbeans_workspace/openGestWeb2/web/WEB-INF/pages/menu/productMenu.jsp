<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	
		<head>
			<title>Open GEST</title>
		</head>
		<%String path = request.getContextPath();%>
		<div id="usermenu" class="left-float-component">
		  <ul id="menulink">
		        <li class="bordered-menu"><a href="<%=path%>/products/createinit"> <fmt:message key="label.product.menu.create.text"/></a></li>
		        <li class="bordered-menu"><a href="<%=path%>/products/list"> <fmt:message key="label.product.menu.list.text"/></a></li>
		    </ul>
		</div>

</html>