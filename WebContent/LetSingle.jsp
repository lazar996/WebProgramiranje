<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<script src="js/jquery-2.1.0.min.js"></script>
<script src="js/hide.js"></script>
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
								<li><a href="AerodromHome">Aerodromi</a></li>
							</ul></li>
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
					<h3 class="panel-title">${requestScope.let.polazniAerodrom.naziv}
						- - - ${requestScope.let.dolazniAerodrom.naziv}</h3>
				</div>
				<div class="panel-body">

					<table class="table">
						<tr>
							<td>Broj Let-a</td>
							<td>${requestScope.let.broj}</td>
						</tr>
						<tr>
							<td>Datum Polaska</td>
							<td><p>
									<f:formatDate pattern="dd.MM.yyyy. HH:mm"
										value="${let.datumPolaska}" />
								</p></td>
						</tr>
						<tr>
							<td>Datum Dolaska</td>
							<td><p>
									<f:formatDate pattern="dd.MM.yyyy. HH:mm"
										value="${let.datumDolaska}" />
								</p></td>
						</tr>

						<tr>
							<td>Polazni Aerodrom</td>
							<td>${requestScope.let.polazniAerodrom.naziv}</td>
						</tr>
						<tr>
							<td>Dolazni Aerodrom</td>
							<td>${requestScope.let.dolazniAerodrom.naziv}</td>
						</tr>
						<tr>
							<td>Broj sedista</td>
							<td>${requestScope.let.brojSedista}</td>
						</tr>
						<tr>
							<td>Cena karte</td>
							<td>${requestScope.let.cenaKarte}Din</td>
						</tr>



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

		<c:when test="${sessionScope.loggedInUser != null }">

			<div class="container">



				<c:choose>
					<c:when test="${sessionScope.loggedInUser.role == 'admin'}">
						<a id="btnChangeInfo" class="commentBtn btn btn-default"
							onClick="return showChangeInfoForm(this)">Izmena Podataka</a>

						<br>

						<form id="changeInfoForm" class="form-horizontal"
							action="LetSingle" method="post">
							<input type="hidden" name="id" value="${requestScope.let.id}">

							<input type="hidden" name="izmenaLet" value="izmena">

							<div class="form-group">
								<label class="col-md-4 control-label whiteClr">Broj
									let-a:</label>
								<div class="col-md-4">
									<input name="brojLeta" type="text"
										class="form-control input-md" value="${requestScope.let.broj}"
										required>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label whiteClr">Datum
									polaska:</label>
								<div class="col-md-4">
									<input type="date" name="date"
										value="${requestScope.let.datumPolaska }" required /> <input
										type="time" name="time"
										value="${requestScope.let.datumPolaska }" required /><br />
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label whiteClr">Datum
									dolaska:</label>
								<div class="col-md-4">
									<input type="date" name="date1"
										value="${requestScope.let.datumDolaska }" required /> <input
										type="time" name="time1"
										value="${requestScope.let.datumDolaska }" required /><br />
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
								<label class="col-md-4 control-label whiteClr">Cena
									karte:</label>
								<div class="col-md-4">
									<input name="cenaKarte" type="number"
										class="form-control input-md"
										value="${requestScope.let.cenaKarte}" required>
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-4 control-label"></label>
								<div class="col-md-8">
									<button type="submit" class="btn btn-default">Potvrda</button>
									<a class="btn btn-default"
										onClick="return hideChangeInfoForm(this)">Odustani</a>
								</div>
							</div>
						</form>

						<br>
						<form action="RezervacijaLet" method="post">
							<input type="hidden" name="action" value="delete">
							<button type="submit" class="btn btn-default">Izbrisi
								let</button>
							<input type="hidden" name="let" value="${requestScope.let.id}">

						</form>
						<br>


					</c:when>
				</c:choose>
				<a id="btnRezervacija" class="btn btn-default"
					onClick="return showRezervacijaForm(this)">Rezervisi Let</a>
				<form id="rezervacijaForm" class="form-horizontal"
					action="RezervacijaLet" method="post">
					<input type="hidden" name="action" value="rezervacija"> <input
						type="hidden" name="let" value="${requestScope.let.id}">
					<div class="form-group">
						<label class="col-md-4 control-label whiteClr">Ime
							putnika:</label>
						<div class="col-md-4">
							<input name="imePutnika" placeholder="Rezervacija na ime?"
								type="text" class="form-control input-md" required>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-4 control-label whiteClr">Prezime
							putnika:</label>
						<div class="col-md-4">
							<input name="prezimePutnika" type="text"
								class="form-control input-md" placeholder="prezime putnika?"
								required>
						</div>
					</div>
					
								
					

					<div class="form-group">
						<label class="col-md-4 control-label whiteClr">Povratni
							Let:</label>
						<div class="col-md-4">




							<input type="radio" name="povratni"
								value="${requestScope.let.id}">Da<br> <input
								type="radio" name="povratniNe" value="${requestScope.let.id}">Ne<br>

						</div>
					</div>

					<div class="form-group">
						<label class="col-md-4 control-label"></label>
						<div class="col-md-8">
							<button type="submit" class="btn btn-default">Potvrda</button>
							<a class="btn btn-default"
								onClick="return hideRezervacijaForm(this)">Odustani</a>
						</div>
					</div>
				</form>

			</div>
		</c:when>
	</c:choose>



</body>
</html>