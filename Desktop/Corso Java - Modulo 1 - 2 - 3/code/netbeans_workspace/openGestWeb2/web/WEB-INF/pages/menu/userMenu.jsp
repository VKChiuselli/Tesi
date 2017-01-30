<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<html>
	
		<head>
			<title>Open GEST</title>
		</head>
		<%String path = request.getContextPath();%>
		<div id="usermenu" class="left-float-component">
		
		<fmt:message key="label.menu.account.text"/>
		  <ul id="menulink">
		        <li class="bordered-menu"><a href="<%=path%>/users/list"><fmt:message key="label.menu.userlist.text"/></a></li>
		        <li class="bordered-menu"><a href="<%=path%>/users/createinit"><fmt:message key="label.menu.newuser.text"/></a></li>
		        <li class="bordered-menu"><a href="#"><fmt:message key="label.menu.account.text"/></a></li>
		    </ul>
		</div>

</html>