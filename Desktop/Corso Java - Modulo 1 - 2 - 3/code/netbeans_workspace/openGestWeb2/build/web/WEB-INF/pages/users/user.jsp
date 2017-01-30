<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.opengest.core.business.dto.UserDTO"%>

							
<html>
	<head>
		<%
			String path = request.getContextPath();
		%>
		<title>Open GEST</title>
		<link rel="stylesheet" type="text/css" href="<%=path%>/resources/styles/users.css"/>
	</head>
	
	<jsp:useBean id="userdata" type="com.opengest.core.business.dto.UserDTO" scope="session"/>
		
	<body class="body-content">
		<div id="wrapper">
			
			<jsp:include page="../tiles/header.jsp"></jsp:include>
			
			<jsp:include page="../menu/menuTab.jsp"></jsp:include>
			
			
			<div id="main-container">
				<div>
				
					<div>
						<jsp:include page="../menu/userMenu.jsp"></jsp:include>
					</div>
					<div class="fieldset right-float-component user-fieldset">
					
						<form action="update" method="post" >
							<input type="hidden" name="userid" value="${userdata.userBean.id}">
							<p>
								<fmt:message key="label.message.header.update.user.text"/>
								<c:out value="${userdata.userBean.account.username}" ></c:out>
							</p>
							<p>
								<c:forEach items="${form.messages}" var="message">
									<span class="error">${message}</span>
								</c:forEach>
							</p>
							<div>
								<label for="username"><fmt:message key="label.anagrafica.username.text"/></label>
								<input id="username" type="text" name="username" value="${userdata.userBean.account.username}"/>
							</div>
							<div>
								<label for="password"><fmt:message key="label.anagrafica.password.text"/></label>
								<input id="password" type="password" name="password" value="${userdata.userBean.account.password}"/>
								<span class="error">${form.messages.password}</span>
							</div>
							<div>
								<label for="nome"><fmt:message key="label.anagraficaNome.text"/></label>
								<input  type="text" name="nome" value="<jsp:getProperty property="nome" name="userdata"/>"/>
								<span class="error">${form.messages.nome}</span>
							</div>
							<div>
								<label for="cognome"><fmt:message key="label.anagraficaCognome.text"/></label>
								<input type="text" name="cognome" value="<jsp:getProperty property="cognome" name="userdata"/>"/>
								<span class="error">${form.messages.cognome}</span>
							</div>
							<div>
								<label for="email"><fmt:message key="label.anagrafica.email.text"/></label>
								<input type="text" name="email" value="${userdata.userBean.account.email}"/>
								<span class="error">${form.messages.email}</span>
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