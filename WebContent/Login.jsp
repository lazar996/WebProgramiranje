<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login page</title>
<script src="js/jquery-2.1.0.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />

</head>
<body>

	<c:choose>
		<c:when test="${sessionScope.loggedInUser != null}">
			<c:redirect url="Home"/>
		</c:when>
	</c:choose>			
	
	
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="Home">Avio Company</a>
			</div>
			<ul class="nav navbar-nav navbar-left">
				<li><a href="Home">Pocetna</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="Login.jsp">Log in</a></li>
				<li><a href="Signup.jsp">Sign up</a></li>
			</ul>
		</div>
	</nav>
	
	
	<div class="container">
		<div class="row">
			<div class="signUpInForm nav_div_margin">
				<form action="Login" method="post">
				
					<p class="success">${requestScope.message}</p>
					<p class="error">${requestScope.PogresanUnos}</p>
					
					<div class="form-group">
						<label>Username</label>
						<input type="text" class="form-control"name="username">
					</div>
					<div class="form-group">
						<label>Password</label>
						<input type="password" class="form-control" name="password">
					</div>
					<button type="submit" class="btn btn-default">Login</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>