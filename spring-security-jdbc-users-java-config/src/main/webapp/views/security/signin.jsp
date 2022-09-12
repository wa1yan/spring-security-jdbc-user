<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
		<h1>Member Sign in</h1>
		<form action="/login" method="post" class="col-4">
			<div class="mb-3">
				<label for="loginId">Login ID</label>
				<input type="text" name="loginId" id="loginId" placeholder="Enter loginId" class="form-control" />
			</div>	
			<div class="mb-4">
				<label for="password">Password</label>
				<input type="password" name="password" id="password" placeholder="Enter password" class="form-control" />
			</div>
			
			<button type="submit" class="btn btn-primary">Login</button>	
			<a href="/" class="btn btn-secondary">Home</a>
		</form>	
	</div>
</body>
</html>