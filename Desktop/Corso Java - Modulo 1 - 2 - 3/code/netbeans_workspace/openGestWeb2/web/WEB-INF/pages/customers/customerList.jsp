<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.Iterator" %>
<%@page import="com.opengest.core.business.vo.ICustomer"%>

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
					
					<div class="user-table-container">
							<table class="user-table">
								<thead> 
									<p>Elenco Clienti </p>
									<tr  class="user-table-header" >
										<th>Codice</th>
										<th>Ragione sociale</th>
										<th>P.iva</th>
									</tr>
								</thead>
								<tbody>
									
								   <c:forEach items='${customerList}' var="current">
										<tr>
											<td>
												<form action="updateinit" method="post">
													<a href="updateinit?customerid=${current.id}">
														<c:out value="${current.code}" />
													</a>
												</form>
											</td>
											<td><c:out value="${current.ragsoc}" /></td>
											<td><c:out value="${current.piva}" /></td>
											<td>
												<form action="delete" method="post" onsubmit="return confirmDelete()">
													<input class="image" type="image" src="<%=path%>/resources/images/delete.png" />
													<input type="hidden" name="customerid" value='<c:out value="${current.id}"/>' />
												</form>
											</td>
										</tr>			
									</c:forEach>	
									
								</tbody>
							</table>
					</div>
				</div>
			</div>
			
			<jsp:include page="../tiles/footer.jsp"></jsp:include>
			
		</div>
	</body>
</html>