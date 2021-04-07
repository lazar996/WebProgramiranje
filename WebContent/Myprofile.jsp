<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="js/jquery-2.1.0.min.js"></script>
<script src="js/hideIzmena.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />

</head>
<body>
<c:choose>
		<c:when test="${sessionScope.loggedInUser == null}">
			<c:redirect url="Login.jsp"/>
		</c:when>
	</c:choose>
	
	
		<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="Home">Avio Company</a>
			</div>
			<ul class="nav navbar-nav navbar-left">
				<li><a href="Home">Home</a></li>
				<c:choose>
					<c:when test="${sessionScope.loggedInUser.role == 'admin'}">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							Admin
							<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li><a href="Users">Users</a></li>
								
							</ul>
						</li>
					</c:when>
				</c:choose>
				<li><a >${sessionScope.loggedInUser.username}</a></li></ul>
			<ul class="nav navbar-nav navbar-right">
					
				<li class="dropdown active">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">
					Profil
					<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li class="active"><a href="Myprofile">Profil</a></li>
					</ul>
				</li>
				<li><a href="Logout">Log out</a></li>
			</ul>
		</div>
		</nav>
		
		<div class="container">
		<div class="row">
			<div class="panel panel-default ">
				<div class="panel-heading">
					<h3 class="panel-title">${sessionScope.loggedInUser.username}</h3>
				</div>
				<div class="panel-body">
					<table class="table">
						<tr>
							<td>Korisnicko ime:</td>
							<td>${sessionScope.loggedInUser.username}</td>
						</tr>
						<tr>
							<td>Datum kreiranja:</td>
							<td>${sessionScope.loggedInUser.datumRegistracije}</td>
						</tr>
						
								<tr>
							<td>Uloga</td>
							<td>${sessionScope.loggedInUser.role}</td>
						</tr>
				
						<tr>
							<td></td>
							<td></td>
						</tr>
					</table>
				</div>
			</div>
	
	<c:choose>
			<c:when test="${sessionScope.loggedInUser.blokiran == false}">
				
				<a id="btnChangePass" class="commentBtn comments-margin btn btn-default" onClick="return showChangePassForm(this)">Promena sifre</a>
				<a id="btnChangeInfo" class="commentBtn btn btn-default" onClick="return showChangeInfoForm(this)">Izmena Podataka</a>
				
			</c:when>
		</c:choose>
	</div>
	<div class="container distance-top">
		<form id="changePassForm" class="form-horizontal" action="Myprofile" method="post">
			<input type="hidden" name="action" value="password">
		
			<div class="form-group">
				<label class="col-md-4 control-label whiteClr">Nova sifra:</label>
				<div class="col-md-4">
					<input name=newPassword type="password" value="${sessionScope.loggedInUser.password}" class="form-control input-md" required>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-md-4 control-label"></label>
				<div class="col-md-8">
					<button type="submit" class="btn btn-default">Potrvrda</button>
					<a class="btn btn-default" onClick="return hideChangePassForm(this)">Odustani</a>
				</div>
			</div>
		</form>
		<form id="changeInfoForm" class="form-horizontal" action="Myprofile" method="post">
			<input type="hidden" name="action" value="info">
			<div class="form-group">
				<label class="col-md-4 control-label whiteClr">Korisnicko ime:</label>
				<div class="col-md-4">
					<input name="username" type="text" class="form-control input-md" value="${sessionScope.loggedInUser.username}" required>
				</div>
			</div>
	
	
			<div class="form-group">
				<label class="col-md-4 control-label"></label>
				<div class="col-md-8">
					<button type="submit" class="btn btn-default">Potvrda</button>
					<a class="btn btn-default" onClick="return hideChangeInfoForm(this)">Odustani</a>
				</div>
			</div>
		</form>
	</div>
	<p id="message" class="success centerLabel">${sessionScope.message}</p>
	<p id="messageFail" class="error centerLabel">${sessionScope.messageFail}</p>
	
			</div>
		
		
		
</body>
</html>