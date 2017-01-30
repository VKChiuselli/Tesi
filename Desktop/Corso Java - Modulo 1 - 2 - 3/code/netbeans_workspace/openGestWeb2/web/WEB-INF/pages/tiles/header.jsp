<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<html>
	<head>
		<%String path = request.getContextPath();%>
		<title>Open GEST</title>
		<link rel="stylesheet" type="text/css" href="<%=path%>/resources/styles/standard.css"/>
		<script type="text/javascript" src="<%=path%>/resources/javascript/application.js"></script>
		
	</head>

			<div id="header">
	 				<div id=navcontainer>
	 					<div id="logo-container">
						        <a href="/home" id="logo"><img id="logo_img" 
						        		alt="OpenGEST" 
						        		src="<%=path%>/resources/images/icon_people_management.png" border="0" class="logo-img">
				        		</a>
	 					</div>
	 					<div id="logo-text">
				        		<div class="logo-text-strong">
					        		<span>
					        			Open GEST 
					        		</span>
				        		</div>
				        		<div class="logo-text-mini">
					        		<span>
					        			Customer Management Experience  
					        		</span>
				        		</div>
	 					</div>
	 				</div>
	 					<%
							String title = "Utente collegato: ";
							if(session.getAttribute("loggedUser") != null) {
								
								String user = (String)session.getAttribute("loggedUser");
								title = title + user;
								
							}
						%>
					        <div id="userinfo">
					        	<ul>
					        		<li>
							        	<p><%=title%></p>
					        		</li>
					        		<li>
							        	<a href="<%=path%>/logout">Log out</a>
					        		</li>
					        	</ul>
					        </div>
			</div>
			<div id="tabs-container" class="wit_group clearfix" name="main tabs">
			</div>
			
	</body>
</html>