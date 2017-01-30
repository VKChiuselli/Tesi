<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.opengest.core.business.dto.ProductDTO"%>

<%@ page import="java.util.Iterator" %>

<jsp:useBean id="product" class="com.opengest.core.business.dto.ProductDTO" scope="session" />
	

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
						<jsp:include page="../menu/productMenu.jsp"></jsp:include>
					</div>
					
					<div class="fieldset right-float-component user-fieldset">
						<form action="update" method="post">
						
							<input type="hidden" name="productid" value="${product.id}">
							<p>
								<fmt:message key="label.message.header.update.product.text"/>
								<c:out value="${product.code}" ></c:out>
							</p>
							<p>
								<c:forEach items="${form.messages}" var="message">
									<span class="error">${message}</span>
								</c:forEach>
							</p>
							<div>
								<label for="code"><fmt:message key="label.product.code.text"/></label>
								<input id="code" type="text" name="code" value="${product.code}"/>
							</div>
							<div>
								<label for="description"><fmt:message key="label.anagrafica.password.text"/></label>
								<input id="description" type="text" name="description" value="${product.description}"/>
							</div>
							<div>
								<label for="price"><fmt:message key="label.anagraficaNome.text"/></label>
								<input id="price" type="text" name="price" value="${product.price}"/>
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