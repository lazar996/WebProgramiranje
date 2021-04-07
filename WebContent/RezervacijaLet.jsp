<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${requestScope.user.username}</title>
<script src="js/jquery-2.1.0.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css" />
</head>
<body>




	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="Home">Avio Company</a>
			</div>
			<ul class="nav navbar-nav navbar-left">
				<li><a href="Home">Pocetna</a></li>


				<c:choose>
					<c:when test="${sessionScope.loggedInUser.blokiran == false}">
						<ul class="nav navbar-nav navbar-right">

							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown"> Rezervacije <span class="caret"></span>
							</a>
								<ul class="dropdown-menu">
									<li><a href="Rezervacije">Nova rezervacije</a></li>
									<li><a href="">Stare rezervacije</a></li>
									<li><a href="MyComments">My Comments</a></li>
									<li><a href="AerodromHome">Aerodrom Home</a></li>
								</ul></li>

						</ul>
					</c:when>

				</c:choose>


				<c:choose>
					<c:when test="${sessionScope.loggedInUser.role == 'admin'}">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> Admin <span class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="Users">Users</a></li>
								<li><a href="Myprofile">profil</a></li>
							</ul></li>
					</c:when>
				</c:choose>
				<li><a href="Myprofile">${sessionScope.loggedInUser.username}</a></li>
			</ul>
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

						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> Profile <span class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="Myprofile">Profile</a></li>
								<li><a href="Letovi">Let</a></li>
								<li><a href="MyComments">My Comments</a></li>
								<li><a href="AerodromHome">Aerodrom Home</a></li>
							</ul></li>
						<li><a href="Logout">Log out</a></li>
					</ul>
				</c:when>

			</c:choose>
		</div>


	</nav>

</body>
</html>