<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Ticket Train - Registration</title>
		<link rel="stylesheet" 
	  		  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	</head>
	<body class="container">
		<h1> Register New User </h1>
		<form action="../Registration" 
			  method="post">
			User Name: <input type="text"
							  name="txtusername"
							  required> <br>
			Password: <input type="password"
							 name="password"
							 required> <br>
			Confirm Password: <input type="password"
									 name="confirmPassword"
									 required> <br>
			Email: <input type="text"
						  name="txtemail"
						  required> <br>
			<input type="submit"
				   value="Register"
				   class="btn btn-primary">
			<a class="btn btn-info" href="../login.html"> Back </a>
		</form>
	</body>
</html>