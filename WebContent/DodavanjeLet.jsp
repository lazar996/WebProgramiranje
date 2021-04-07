<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Signup page</title>
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
									<li><a href="Home">Nova rezervacije</a></li>
									<li><a href="Rezervacije">Moje rezervacije</a></li>
									<li><a href="AerodromHome">Aerodromi</a></li>
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
								<li><a href="DodavanjeLet">Dodavanje Let-a</a></li>
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
							data-toggle="dropdown"> Korisnicki Nalog <span class="caret"></span>
						</a>
							<ul class="dropdown-menu">
								<li><a href="Myprofile">Profile</a></li>
								<li><a href="AerodromHome">Aerodromi</a></li>
							</ul></li>
						<li><a href="Logout">Log out</a></li>
					</ul>
				</c:when>

			</c:choose>
		</div>


	</nav>
	<center>
		<h3>Dodavanje Novog Let-a</h3>
	</center>
	<br>
	<br>

	<c:choose>

		<c:when test="${sessionScope.loggedInUser != null }">

			<div class="container">



				<c:choose>
					<c:when test="${sessionScope.loggedInUser.role == 'admin'}">

						<form id="changeInfoForm" class="form-horizontal"
							action="DodavanjeLet" method="post">
							<input type="hidden" name="id" value="${requestScope.let.id}">

							<input type="hidden" name="izmenaLet" value="izmena">

							<div class="form-group">
								<label class="col-md-4 control-label whiteClr">Broj
									let-a:</label>
								<div class="col-md-4">
									<input name="brojLeta" type="number" placeholder="broj let-a"
										class="form-control input-md" value="brojLeta" required>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label whiteClr">Datum
									polaska:</label>
								<div class="col-md-4">
									<input type="date" name="date" required /> <input type="time"
										name="time" required /><br />

								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label whiteClr">Datum
									dolaska:</label>
								<div class="col-md-4">

									<input type="date" name="date1" required /> <input type="time"
										name="time1" required /><br />


								</div>
							</div>
							
							

							<div class="form-group">
								<label class="col-md-4 control-label whiteClr">Polazni
									Aerodrom :</label>
								<div class="col-md-4">
									<select name="polazniAerodrom">
										<c:forEach var="aerodrom" items="${requestScope.aerodroms}">

											<option value="${aerodrom.id}"
												${aerodrom.id == aerodrom.id ? 'selected' : ''}>${aerodrom.naziv}</option>

										</c:forEach>
									</select>
								</div>
							</div>


							<div class="form-group">
								<label class="col-md-4 control-label whiteClr">Dolazni
									Aerodrom :</label>
								<div class="col-md-4">
									<select name="dolazniAerodrom">
										<c:forEach var="aerodrom" items="${requestScope.aerodroms}">

											<option value="${aerodrom.id}"
												${aerodrom.id == aerodrom.id ? 'selected' : ''}>${aerodrom.naziv}</option>

										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label whiteClr">Broj
									sedista:</label>
								<div class="col-md-4">
									<input name="brojSedista" type="number"
										class="form-control input-md" value="brojSedista" required>
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-4 control-label whiteClr">Cena
									karte:</label>
								<div class="col-md-4">
									<input name="cenaKarte" type="number"
										class="form-control input-md" value="cenaKarte" required>
								</div>
							</div>
							
							<h4>Datum i vreme za povratini let</h4>
							
														<div class="form-group">
								<label class="col-md-4 control-label whiteClr">Datum
									polaska:</label>
								<div class="col-md-4">
									<input type="date" name="datePovratni" required /> <input type="time"
										name="timePovratni" required /><br />

								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label whiteClr">Datum
									dolaska:</label>
								<div class="col-md-4">

									<input type="date" name="datePovratni1" required /> <input type="time"
										name="timePovratni1" required /><br />


								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label"></label>
								<div class="col-md-8">
									<button type="submit" class="btn btn-default">Potvrda</button>

								</div>
							</div>
						</form>

						<br>


					</c:when>
				</c:choose>



			</div>
		</c:when>
	</c:choose>

</body>
</html>