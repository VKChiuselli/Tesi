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
								<fmt:message key="label.message.header.create.customers.text"/>
							</p>
							<p>
								<span class="error">${form.messages.code}</span>
							</p>
							<div>
								<label for="code"><fmt:message key="label.customers.code.text"/></label>
								<input id="code" type="text" name="code" value="${param.code}"/>
							</div>
							<div>
								<label for="ragsoc"><fmt:message key="label.customers.ragsoc.text"/></label>
								<input id="ragsoc" type="text" name="ragsoc" value="${param.ragsoc}"/>
								<span class="error">${form.messages.ragsoc}</span>
							</div>
							<div>
								<label for="piva"><fmt:message key="label.customers.piva.text"/></label>
								<input  type="text" name="piva" value="${param.piva}"/>
								<span class="error">${form.messages.piva}</span>
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