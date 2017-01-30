<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.opengest.core.business.dto.OrderDTO"%>

							
<html>
	<head>
		<%
			String path = request.getContextPath();
		%>
		<title>Open GEST</title>
		<link rel="stylesheet" type="text/css" href="<%=path%>/resources/styles/users.css"/>
	</head>
	
	<jsp:useBean id="order" type="com.opengest.core.business.dto.OrderDTO" scope="request"/>
		
	<body class="body-content">
		<div id="wrapper">
			
			<jsp:include page="../tiles/header.jsp"></jsp:include>
			
			<jsp:include page="../menu/menuTab.jsp"></jsp:include>
			
			
			<div id="main-container">
				<div>
				
					<div>
						<jsp:include page="../menu/orderMenu.jsp"></jsp:include>
					</div>
					<div class="fieldset right-float-component user-fieldset">
					
						<form action="update" method="post" >
							<input type="hidden" name="orderid" value="${order.orderBean.id}">
							<p>
								<fmt:message key="label.message.header.update.user.text"/>
								<c:out value="${userdata.userBean.account.username}" ></c:out>
							</p>
							<p>
								<c:forEach items="${form.messages}" var="message">
									<span class="error">${message}</span>
								</c:forEach>
							</p>

								<fmt:message key="button.confirm" var="confirm"/>
								<input type="submit" class="button-standard" value="${confirm}"> 
						</form>
					</div>
				</div>
			</div>
			
			<jsp:include page="../tiles/footer.jsp"></jsp:include>
			
		</div>
	</body>
</html>