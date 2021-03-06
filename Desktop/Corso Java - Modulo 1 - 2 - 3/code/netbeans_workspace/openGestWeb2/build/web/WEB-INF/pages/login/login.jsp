<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	
	String message = "";
	if(request.getAttribute("errorMsg") != null) {
		message = (String)request.getAttribute("errorMsg");
	}
	String path = request.getContextPath();
%>

<html>

	<head>
		<title>Open GEST</title>
		<link rel="stylesheet" type="text/css" href="<%=path%>/resources/styles/standard.css"/>
		<link rel="stylesheet" type="text/css" href="<%=path%>/resources/styles/menu.css"/>
	</head>
	
	<body class="body-content">
		<div id="wrapper">
			<div id="header">
 				<div id=navcontainer>
 					<div id="logo-container">
					        <a href="/home" id="logo"><img id="logo_img" 
					        		alt="" 
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
			</div>
			<div id="tabs-container" class="wit_group clearfix" name="main tabs">
			</div>			
			<div id="main-container">
			
				 <form id="login_form" action="login" method="post">
			
			
						<table class="login-table" >
									<tr class="header-login">
										<td align="center" colspan="2"><font size="5">User Login</font></td>
									</tr>
									<tr>
										<td colspan="2">
											<div class="error-msg">
												<p><%=message %></p>
											</div>
										</td>
									</tr>
									<tr align="center">
										<td align="right">User ID:</td>
										<td><input type="text" name="username" size="30" maxlength="30" /></td>
									</tr>
					
									<tr align="center">
										<td align="right">Password:</td>
										<td><input type="password" name="password" size="30" maxlength="30" /></td>
									</tr>
					
					
									<tr>
										<td colspan="2">
										<p>&nbsp;</p>
										</td>
									</tr>
					
									<tr>
										<td align="center" colspan="2">
											<input type="submit" title="Login Now" class="button-standard">
										</td>
									</tr>
						</table>
				</form>
			</div>
			<div id="footer" class="wit_group" >
	
	            <p id="copyright">
	                  <img src="<%=path%>/resources/images/icons/icon_spacer.gif" alt="" class="sprite s_gray_logo text-img">� 2015 2Clever<br>
	            </p>
	            
	            <div class="footer-col">
	                <ul>
	                    <li class="header">Open GEST</li>
	                    <li><a href="/">Home</a></li>
	                    <li><a href="/teams">Terms</a></li>
	                    <li><a href="/features">Features</a></li>
	                </ul>
	            </div>
	            <div class="footer-col">
	                <ul>
	                    <li class="header">About Us</li>
	                    <li><a href="http://www.2clever.it/">2Clever</a></li>
	                    <li><a href="/teams">Team</a></li>
	                    <li><a href="/features">Courses</a></li>
	                    <li><a href="/tour">Tour</a></li>
	                </ul>
	            </div>
	            <div class="footer-col">
	                <ul>
	                    <li class="header">Support</li>
	                    <li><a href="/help">Help Center</a></li>
	                    <li><a href="#">Feedback</a></li>
	                    <li><a href="/contact">Contact Us</a></li>
	                </ul>
	            </div>
	            <div class="footer-col">
	                <ul>
	                    <li class="header">Community</li>
	                    <li><a href="http://twitter.com/" target="_blank">Twitter</a></li>
	                    <li><a href="http://facebook.com/" target="_blank">Facebook</a></li>
	                    <li><a href="/developers">Developers</a></li>
	                </ul>
	            </div>
	           <div class="clear"></div>
	        
			</div>
		</div>		
	<body>
</html>
