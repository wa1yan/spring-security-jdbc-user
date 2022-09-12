<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
</head>
<body>
<div class="container row mt-4">
		<h1>Member Sign up</h1>
		<sf:form action="/signup" class="col-4" modelAttribute="signUpDto">
		
			<div class="mb-3">
				<sf:label path="name">Name</sf:label>
				<sf:input path="name" placeholder="Enter name" class="form-control"/>
				<sf:errors path="name"></sf:errors>
			</div>	
			<div class="mb-3">
				<sf:label path="loginId">Name</sf:label>
				<sf:input path="loginId" placeholder="Enter loginId" class="form-control"/>
				<sf:errors path="loginId"></sf:errors>
			</div>	
			<div class="mb-3">
				<sf:label path="password">Password</sf:label>
				<sf:password path="password" placeholder="Enter password" class="form-control"/>
				<sf:errors path="password"></sf:errors>
			</div>
			
			
			<button type="submit" class="btn btn-primary">Sign Up</button>	
			
		</sf:form>
	</div>
</body>
</html>