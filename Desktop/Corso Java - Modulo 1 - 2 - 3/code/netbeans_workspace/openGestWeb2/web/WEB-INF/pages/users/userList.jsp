<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@page import="com.opengest.core.business.vo.UserVO"%>
<%@ page import="java.util.Iterator" %>

<html>
	<head>
		<%String path = request.getContextPath();%>
		<title>Open GEST</title>
		<link rel="stylesheet" type="text/css" href="<%=path%>/resources/styles/users.css"/>
		
	</head>
		<jsp:useBean id="userList" class="java.util.Vector" scope="request"></jsp:useBean>
	
	<body class="body-content">
		<div id="wrapper">
			
			<jsp:include page="../tiles/header.jsp"></jsp:include>
			
			<jsp:include page="../menu/menuTab.jsp"></jsp:include>
			
			
			<div id="main-container">
				<div>
					<div>
						<jsp:include page="../menu/userMenu.jsp"></jsp:include>
					</div>
					
					<div class="user-table-container">
							<table class="user-table">
								<thead> 
									<p>Tabella partecipanti al corso </p>
									<tr  class="user-table-header" >
										<th>Username</th>
										<th>Nome</th>
										<th>Cognome</th>
										<th>Email</th>
									</tr>
								</thead>
								<tbody>
									<%
										Iterator iterator = userList.iterator();
										while(iterator.hasNext()){
											UserVO current = (UserVO)iterator.next();
									%>
										<tr>
											<td>
												<form action="updateinit" method="post">
													<a href="updateinit?userid=<%=current.getId()%>">
														<%=current.getAccount().getUsername()%>
													</a>
												</form>
											</td>
											<td><%=current.getNome()%></td>
											<td><%=current.getCognome()%></td>
											<td><%=current.getAccount().getEmail()%></td>
											<td>
												<form action="delete" method="post" onsubmit="return confirmDelete()">
													<input class="image" type="image" src="<%=path%>/resources/images/delete.png" />
													<input type="hidden" name="userid" value="<%=current.getId()%>">
												</form>
											</td>
										</tr>	
									<%
										}
									%>	
					
					
								</tbody>
					<%--			
								<c:forEach items='${utenti}' var="current">
									<tr>
										<td>Nome:<c:out value='${current.name}'></c:out> </td>
										<td>Ruolo:<c:out value='${current.mansione}'></c:out> </td>
									</tr>				
								</c:forEach>
					 --%>	
							</table>
					</div>
				</div>
			</div>
			
			<jsp:include page="../tiles/footer.jsp"></jsp:include>
			
		</div>
	</body>
</html>