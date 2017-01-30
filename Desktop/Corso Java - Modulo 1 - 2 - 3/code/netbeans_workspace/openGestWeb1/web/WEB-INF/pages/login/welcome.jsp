<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="com.opengest.core.business.dto.UserDTO"%>
<html>
	<head>
		<title>Open GEST</title>
		<link rel="stylesheet" type="text/css" href="styles/standard.css"/>
	</head>
	
	<body class="body-content">
		<div id="wrapper">
			<div id="header">
	 				<div id=navcontainer>
	 					<div id="logo-container">
						        <a href="/home" id="logo"><img id="logo_img" 
						        		alt="Open GEST" 
						        		src="images/icon_people_management.png" border="0" class="logo-img">
							
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
			        <div id="userinfo">
			        	<ul>
			        		<li>
					        	<p>Utente collegato: <%= ((UserDTO)session.getAttribute("loggedUser")).getUserBean().getUsername() %></p>
			        		</li>
			        		<li>
					        	<a href="logout">Log out</a>
			        		</li>
			        	</ul>
			        </div>
			</div>
			<div id="tabs-container" class="wit_group clearfix" name="main tabs">
			</div>
<%--
			<jsp:include page="../menu/menuTab.jsp"></jsp:include>
 --%>			
			
			
			<div id="main-container">
				<div class="fieldset">
					<p>
						Benvennuto in <span class="bold-text">Open GEST</span> il gestionale aziendale a portata di tutti.
					</p>
					<p>
						Open GEST è basato su tecnologie open sourse tra le più avanzate e performanti 
					</p>
					<p>
						Utilizza i menu principali per navigare attraverso le sue funzionalità.
					</p>
				</div>
			</div>
			
			
			<div id="footer" class="wit_group" >
	
	            <p id="copyright">
	                 <img src="/images/icons/icon_spacer.gif" alt="" class="sprite s_gray_logo text-img">© 2014 2Clever<br>
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
	</body>
</html>