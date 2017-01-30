<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<html>
	
		<head>
			<title>Open GEST</title>
		</head>
		<%String path = request.getContextPath();%>
		<div id="usermenu" class="left-float-component">
		  <ul id="menulink">
		        <li class="bordered-menu"><a href="<%=path%>/orders/list"> <fmt:message key="label.orders.orderlist.text"/></a></li>
		        <li class="bordered-menu"><a href="<%=path%>/orders/createinit"><fmt:message key="label.message.header.create.order.text"/></a></li>
		    </ul>
		</div>

</html>