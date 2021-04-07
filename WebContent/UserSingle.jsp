<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${requestScope.user.username}</title>
<script src="js/jquery-2.1.0.min.js"></script>
<script src="js/userpanel.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
</head>
<body>
<c:choose>
		<c:when test="${requestScope.user == null}">
			<c:redirect url="./Login.jsp"/>
		</c:when>
	</c:choose>	
	
	
		<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="Home">Avio Company</a>
			</div>
			<ul class="nav navbar-nav navbar-left">
				<li><a href="Home">Pocetna</a></li>
				<li><a href="Home">Rezervacije</a></li>
				<c:choose>
					<c:when test="${sessionScope.loggedInUser.role == 'admin'}">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							Admin
							<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li><a href="Users">Users</a></li>
								<li><a href="Myprofile">profil</a></li>
							</ul>
						</li>
					</c:when>
				</c:choose>
				<li><a href="Myprofile">${sessionScope.loggedInUser.username}</a></li></ul>
			<c:choose>

				<c:when test="${sessionScope.loggedInUser == null}">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="Login.jsp">Log in</a></li>
						<li><a href="Signup.jsp">Sign up</a></li>
					</ul>
				</c:when>			
			</c:choose>

				
							<c:choose>
				<c:when test="${sessionScope.loggedInUser != null}">
					<ul class="nav navbar-nav navbar-right">
						
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							Profile
							<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li><a href="Myprofile">Profile</a></li>
								<li><a href="Letovi">Let</a></li>
								<li><a href="AerodromHome">Aerodrom Home</a></li>
							</ul>
						</li>
						<li><a href="Logout">Log out</a></li>
					</ul>
				</c:when>
			
			</c:choose>
		</div>
		

	</nav>
	
	<div class="container">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">${requestScope.user.username}</h3>
				</div>
				<div class="panel-body">
					<table class="table">
						<tr>
							<td>Korisnicko ime</td>
							<td>${requestScope.user.username}</td>
						</tr>
						<c:choose>
							<c:when test="${sessionScope.loggedInUser.role == 'admin'}">
							
							</c:when>
						</c:choose>
					
											<tr>
							<td>Datum Registracije</td>
							<td>${requestScope.user.datumRegistracije}</td>
						</tr>
					
						<tr>
							<td>Uloga</td>
							<td>${requestScope.user.role}</td>
						</tr>
						
						<c:choose>
							<c:when test="${requestScope.user.role != 'admin'}">
								<tr>
									<td>Blokiran</td>
									<c:choose>
										<c:when test="${requestScope.user.blokiran == true}">
											<td>Da</td>
										</c:when>
										<c:when test="${requestScope.user.blokiran == false}">
											<td>Ne</td>
										</c:when>
									</c:choose>
								</tr>						
							</c:when>
						</c:choose>

						<tr>
							<td></td>
							<td></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>

	<c:choose>
		<c:when test="${sessionScope.loggedInUser != null and sessionScope.loggedInUser.role == 'admin' and requestScope.user.role == 'user'}">
			
			<div class="container">
				<button id="btnDelete" class="btn btn-default">Izbrisi nalog</button>
					<br>
				<c:choose>
					<c:when test="${requestScope.user.blokiran == true}">
						<form action="UserSingle" method="post">
							<input type="hidden" name="action" value="unban">
							<input type="hidden" name="username" value="${requestScope.user.username}">
							<button type="submit" class="btn btn-default">Odblokiraj nalog</button>
						</form>					
					</c:when>
				</c:choose>
						<br> 
							
				<c:choose>
					<c:when test="${requestScope.user.blokiran == false}">
						<form action="UserSingle" method="post">
							<input type="hidden" name="action" value="ban">
							<input type="hidden" name="username" value="${requestScope.user.username}">
							<button type="submit" class="btn btn-default">Blokiraj nalog</button>
							
						</form>
					</c:when>
				</c:choose>	
				<br>
				<c:choose>
					<c:when test="${requestScope.user.role == 'user'}">
						<form action="UserSingle" method="post">
							<input type="hidden" name="action" value="admin">
							<input type="hidden" name="username" value="${requestScope.user.username}">
							<button class="btn btn-default">Admin</button>
						</form>
					</c:when>	
				</c:choose>		
					
				<form id="deleteForm" action="UserSingle" method="post">
					<input type="hidden" name="action" value="delete">
					<input type="hidden" name="username" value="${requestScope.user.username}">
					
				</form>
			</div>
		</c:when>
	</c:choose>

</body>
</html>