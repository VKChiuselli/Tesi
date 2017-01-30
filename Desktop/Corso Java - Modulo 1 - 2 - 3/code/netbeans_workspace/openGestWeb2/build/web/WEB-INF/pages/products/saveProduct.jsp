<%@ page language="java" contentType="text/html" %>

<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="com.opengest.core.business.dto.ProductDTO"%>



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
						<form action="create" method="post">
							
							<p>
								<fmt:message key="label.message.header.update.product.text"/>
								<c:out value="${product.code}" ></c:out>
							</p>
							<div>
								<label for="code"><fmt:message key="label.product.code.text"/></label>
								<input id="code" type="text" name="code" value="${param.code}"/>
							</div>
							<div>
								<label for="description"><fmt:message key="label.product.description.text"/></label>
								<input id="description" type="text" name="description" value="${param.description}"/>
							</div>
							<div>
								<label for="price"><fmt:message key="label.product.price.text"/></label>
								<input id="price" type="text" name="price" value="${param.price}"/>
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