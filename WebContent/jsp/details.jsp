<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" 
			  content="text/html; charset=ISO-8859-1">
		<title>Train Ticket -- Ticket Details</title>
		<link rel="stylesheet" 
	  		  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
		<script src="js/details.js"></script>
	</head>
	<body class="container text-center">
		<h2> When Do You Want to Go </h2>
		<form action="./TrainPassenger" 
			  method="post">
			Please pick a date:
			<input type="date"
				   id="day" 
				   name="day"> <br>
			<br>
			<h2> Number of Passengers </h2>
			How many passengers will there be? 
			<input type="number" 
				   name="num_passengers"
				   min="1"
				   max="6"> <br>
			<input type="submit"
				   id="sub"
				   value="Next">
		</form>
	</body>
</html>