<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.opengest.core.business.vo.ProductVO"%>
<%@ page import="java.util.Iterator" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<%String path = request.getContextPath();%>
		<title>Open GEST</title>
		<link rel="stylesheet" type="text/css" href="<%=path%>/resources/styles/users.css"/>
		
	</head>
		<jsp:useBean id="productList" class="java.util.Vector" scope="request"></jsp:useBean>
	
	<body class="body-content">
		<div id="wrapper">
			
			<jsp:include page="../tiles/header.jsp"></jsp:include>
			
			<jsp:include page="../menu/menuTab.jsp"></jsp:include>
			
			
			<div id="main-container">
				<div>
					<div>
						<jsp:include page="../menu/productMenu.jsp"></jsp:include>
					</div>
					
					<div class="user-table-container">
							<table class="user-table">
								<thead> 
									<p><fmt:message key="label.message.header.list.product.text"/> </p>
									<p>
										<span class="error">${errorMSG}</span>
									</p>
									<tr  class="user-table-header" >
										<th><fmt:message key="label.product.code.text"/> </th>
										<th><fmt:message key="label.product.description.text"/> </th>
										<th><fmt:message key="label.product.price.text"/> </th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items='${productList}' var="current">
										<tr>
											<td>
												<form action="updateinit" method="post">
													<a href="updateinit?productid=${current.id}">
														${current.code}
													</a>
												</form>
											</td>
											<td>${current.description}</td>
											<td>${current.price}</td>
											<td>
												<form action="delete" method="post" onsubmit="return confirmDelete()">
													<input class="image" type="image" src="<%=path%>/resources/images/delete.png" />
													<input type="hidden" name="productid" value="${current.id}">
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