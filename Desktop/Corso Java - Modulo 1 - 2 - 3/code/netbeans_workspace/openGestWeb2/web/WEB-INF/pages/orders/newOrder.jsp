<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.opengest.core.business.dto.UserDTO"%>

							
<html>
	<head>
		<%String path = request.getContextPath();%>
		<title>Open GEST</title>
		<link rel="stylesheet" type="text/css" href="<%=path%>/resources/styles/users.css"/>
	</head>
	
		
	<body class="body-content">
		<div id="wrapper">
			
			<jsp:include page="../tiles/header.jsp"></jsp:include>
			
			<jsp:include page="../menu/menuTab.jsp"></jsp:include>
			
			<div id="main-container">
				<div>
				
					<div>
						<jsp:include page="../menu/customerMenu.jsp"></jsp:include>
					</div>
					<div class="fieldset right-float-component user-fieldset">
					
						<form action="create" method="post" >
							<p>
								<fmt:message key="label.message.header.create.order.text"/>
							</p>
							<p>
								<span class="error">${form.messages.code}</span>
							</p>
							
							<div>
								<label for="productSelect"><fmt:message key="label.orders.product.text"/></label>
								<select id="productSelect">
									<c:forEach items="${productList}" var="prod">
										<option id="product" 
												value="${prod.id}"
												<c:if test="${prod.id eq param.product}"> selected="selected"</c:if>
												>${prod.description} - ${prod.code}</option>
									</c:forEach>
								</select>
							</div>
							<div>
								<label for="customerList"><fmt:message key="label.orders.customer.text"/></label>
								<select id="customerList" >
									<c:forEach items="${customerList}" var="cust">
										<option id="customer" 
												value="${cust.id}"
												<c:if test="${cust.id eq param.customer}"> selected="selected"</c:if>
												>${cust.ragsoc}</option>
									</c:forEach>
								</select>
							</div>
							<div>
								<label for="quantity"><fmt:message key="label.orders.quantity.text"/></label>
								<input  type="text" name="quantity" value="${param.quantity}"/>
							</div>
							<div>
								<label for="orderdate"><fmt:message key="label.orders.orderdate.text"/></label>
								<input  type="text" name="orderdate" value="${param.orderdate}"/>
							</div>
							
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