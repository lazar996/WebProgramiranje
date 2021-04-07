<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Manage users</title>
<script src="js/jquery-2.1.0.min.js"></script>
<script src="js/users.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css" />
</head>
<body>
<c:choose>
		<c:when test="${sessionScope.loggedInUser.role != 'admin'}">
			<c:redirect url="Home"/>
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
	
	

	
		<form action="Users" method="post">
		<div class="container distance-bottom">
	
		
			<div class="distance-bottom">
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
					
				</div>
					
			</div>
	
		</div>
		
				<button  value ="asc"  name="action"  class="btn btn-default" >Sort Asc </button>
				<button  value ="desc" name ="action" class="btn btn-default">Sort Desc </button>
		
	</form>
	

	<c:forEach var="user" items="${requestScope.users}">
		<div class="container-fluid float-left">
		
			<div class="itemText">
			<hr>
				<p>Korisnicko ime:</p>
				<a class="warrning" href="UserSingle?username=${user.username}">${user.username}</a>
				<br>
				<br>
				<p>Uloga:</p>
				<p class="text-info">${user.role}</p>
				<p>Create date:</p>
				<p class="text-info">${user.datumRegistracije}</p>
				<hr>
			</div>
		</div>
	</c:forEach>
	
	
</body>
</html>