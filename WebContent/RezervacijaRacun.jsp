<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
 <%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rezervacija/Racun</title>
<script src="js/jquery-2.1.0.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
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
						
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							Rezervacije
							<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li><a href="Home">Nova rezervacije</a></li>
								<li><a href="Rezervacije">Moje rezervacije</a></li>
								<li><a href="AerodromHome">Aerodromi</a></li>
							</ul>
						</li>
					
					</ul>
				</c:when>
			
			</c:choose>
					
					
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
								<li><a href="MyComments">My Comments</a></li>
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
					<h3 class="panel-title">Rezervacija/Racun </h3>
				</div>
				<div class="panel-body">
				
					<table class="table">
						
							<tr><td><h3>Polazni Let</h3></td>
							<td></td></tr>
						
						<tr>
						
						
							<td>Polazni Aerodrom</td>
							<td>${rezervacije.polazniLet.polazniAerodrom.naziv}</td>
						</tr>
						
						<tr>
							<td>Dolazni Aerodrom</td>
							<td>${rezervacije.polazniLet.dolazniAerodrom.naziv}</td>
						</tr>
						<tr>
							<td>Datum Polaska</td>
							<td ><p><f:formatDate pattern="dd.MM.yyyy. HH:mm" value="${rezervacije.polazniLet.datumPolaska}"/></p></td>
						</tr>
												<tr>
							<td>Datum Dolaska</td>
							<td><p><f:formatDate pattern="dd.MM.yyyy. HH:mm" value="${rezervacije.polazniLet.datumDolaska}"/></p></td>
						</tr>

						<tr>
							<td>Broj Sedista </td>
							<td>${rezervacije.polazniLet.brojSedista}</td>
						</tr>
						<tr>
							<td>Cena Karte</td>
							<td>${rezervacije.polazniLet.cenaKarte} Din</td>
						</tr>

						<tr><td><h3>Povratni Let</h3></td>
							<td></td></tr>
						<tr>
							<td>Povratni Let</td>
							<td>${rezervacije.povratniLet.polazniAerodrom.naziv}</td>
						</tr>
						<tr>
						<td>Dolazni Aerodrom</td>
							<td>${rezervacije.povratniLet.dolazniAerodrom.naziv}</td>
						</tr>
						<tr>
							<td>Datum Polaska</td>
							<td ><p><f:formatDate pattern="dd.MM.yyyy. HH:mm" value="${rezervacije.povratniLet.datumPolaska}"/></p></td>
						</tr>
												<tr>
							<td>Datum Dolaska</td>
							<td><p><f:formatDate pattern="dd.MM.yyyy. HH:mm" value="${rezervacije.povratniLet.datumDolaska}"/></p></td>
						</tr>

						<tr>
							<td>Broj Sedista </td>
							<td>${rezervacije.povratniLet.brojSedista}</td>
						</tr>
						<tr>
							<td>Cena Karte</td>
							<td>${rezervacije.povratniLet.cenaKarte} Din</td>
						</tr>
			


						<tr>
							<td><h3>info: </h3></td>
							<td></td>
													<tr>
													
							<td>Datum Prodaje Karte</td>
							<td><h4>${rezervacije.datumProdajeKarte}</h4></td>
						</tr>
												<tr>
							<td>Ime i Prezime Putnika</td>
							<td><h4>${rezervacije.imePutnika} ${rezervacije.prezimePutnika}</h4></td>
						</tr>
						
					</table>
					
				</div>
			</div>
		</div>
	</div>



</body>
</html>