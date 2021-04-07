<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="js/jquery-2.1.0.min.js"></script>
<script src="js/home.js"></script>

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

	<br>


	<form action="Home" method="post">

		
		<div id="leftNavigation" class="left">
			<div class="item">
				<span class="glyphicon"></span>
				
				Filtriranje: 
			</div>
			<br>
			<div class="item">
				<span class="glyphicon"></span>
				Broj Polaska
				<input type="checkbox" name="brojPolaska">
			</div>
			<div class="item">
				<span class="glyphicon"></span>
				Polazni aerodrom
				<input type="checkbox" name="PolazniAerodrom">
			</div>
						<div class="item">
				<span class="glyphicon"></span>
				Dolazni Aerodrom
				<input type="checkbox" name="dolazniAerodrom">
			</div>
			<div class="item">
				<span class="glyphicon"></span>
				Cena Karte
				<input type="checkbox" name="cenaKarte">
			</div>
			
						<div class="item">
				<span class="glyphicon"></span>
				Datumu Polaska
				<input type="checkbox" name="datumPolaska">
			</div>
			
								<div class="item">
				<span class="glyphicon"></span>
				Datumu Dolaska
				<input type="checkbox" name="datumDolaska">
			</div>

			<div class="item">
			<br>
				<span class="glyphicon"></span>
				Sortiranje: 
			</div>
			<br>
			<div class="item">
				<span class="glyphicon"></span>
				Ascending
				<input type="radio" name="sortBy" value="true"/>
			</div>
			<div class="item">
				<span class="glyphicon"></span>
				Descending
				<input type="radio" name="sortBy" value="false"/>
			</div>
		</div>
		<div class="container distance-bottom">
			<div class="row">
				<div class="col-sm-6 col-sm-offset-3">
					<div class="input-group stylish-input-group">
						<input type="text" class="form-control" placeholder="Search..." name="searchInput">
						<span class="input-group-addon">
							<button type="submit">
								<span class="glyphicon glyphicon-search"></span>
							</button>
						</span>
					</div>
				</div>
				<button type="button" id="btnFilter" class="btn btn-info">Filter</button>
			</div>
		</div>
	
		<div class="container distance-bottom">

			<fieldset>
				<legend>Unesite vase odrediste:</legend>
				<div>
					<div class="form-group">
						<label class="col-md-8 control-label whiteClr">Polazni
							Aerodrom :</label>
						<div class="col-md-4">
							<select name="polazniAerodromTrazi">
								<c:forEach var="aerodrom" items="${requestScope.aerodroms}">

									<option value="${aerodrom.id}"
										${aerodrom.id == aerodrom.id ? 'selected' : ''}>${aerodrom.naziv}</option>

								</c:forEach>
							</select>
						</div>
					</div>


					<div class="form-group">
						<label class="col-md-8 control-label whiteClr">Dolazni
							Aerodrom :</label>
						<div class="col-md-4">
							<select name="dolazniAerodromTrazi">
								<c:forEach var="aerodrom" items="${requestScope.aerodroms}">

									<option value="${aerodrom.id}"
										${aerodrom.id == aerodrom.id ? 'selected' : ''}>${aerodrom.naziv}</option>

								</c:forEach>
							</select> <br>
						</div>
						<br>
					</div>


					<div class="col-md-4">
						<button value="trazi" name="action" class="btn btn-default">Potvrda</button>

					</div>
				</div>

			</fieldset>


		</div>
</form>


	

	<br>

	<table id="total votes" class="table table-hover text-centered"
		border="1">

		<tr>
			<th>Broj Polaska</th>
			<th>Polazni Aerodrom</th>
			<th>Dolazni Aerodrom</th>
			<th>Datum Polaska</th>
			<th>Datum Dolaska</th>
			<th>Broj Sedista</th>
			<th>Cena Karte</th>
		</tr>

		<c:forEach var="let" items="${requestScope.lets}">

			<tr onclick="location.href='LetSingle?Let=${let.id}'">

				<td>
					<p>
						<c:out value="${let.broj}" />
					</p>
				</td>

				<td>
					<p>
						<c:out value="${let.polazniAerodrom.naziv}" />
					</p>
				</td>

				<td>
					<p>
						<c:out value="${let.dolazniAerodrom.naziv}" />
					</p>
				</td>


				<td>
					<p>
						<f:formatDate pattern="dd.MM.yyyy. HH:mm"
							value="${let.datumPolaska}" />
					</p>
				</td>


				<td>
					<p>
						<f:formatDate pattern="dd.MM.yyyy. HH:mm"
							value="${let.datumDolaska}" />
					</p>
				</td>

				<td>
					<p>
						<c:out value="${let.brojSedista}" />
					</p>
				</td>

				<td>
					<p>
						<c:out value="${let.cenaKarte}" />
					</p>
				</td>

			</tr>
		</c:forEach>
	</table>


</body>
</html>