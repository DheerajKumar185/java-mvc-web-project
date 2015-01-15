<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix= "spring" uri = "http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Welcome!!!</h1>
${loginError}
<form action="hello" method="post">
	<div>
		<label>User Name:</label>
		<input type="text" name="userId" placeholder="user name" class="form-control">
	</div>
	<div>
		<label>Password:</label>
		<input type="password" name="password" placeholder="Password" class="form-control">
	</div>
	<button id="loginButton" class="form-control">Login</button>
</form>
</body>
</html>