<%@ page language="java" 
		 contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
		   prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" 
			  content="text/html; charset=ISO-8859-1">
		<title>Ticket Train -- Passenger Details</title>
		<link rel="stylesheet" 
	  		  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	</head>
	<body class="container">
			<form action="./Passenger"
				  method="post">
				
					
					<c:forEach var="i"
							   begin="1"
							   end="${ count }"
							   step="1">
					<h2> Passenger ${ i } </h2>
					<div class="row">
						<div class="col">
							<input type="text"
								   name="namepassenger${ i }"
								   class="form-control"
								   placeholder="Enter Passenger Name"
								   required>
						</div>
						<div class="col">
							<input type="number"
								   name="agepassenger${ i }"
								   placeholder="Enter Age"
								   class="form-control"
								   min="0"
								   required>
						</div>
						<div class="col">
							<input type="radio"
								   name="genderpassenger${ i }"
								   value="M"
								   checked> Male
							<input type="radio"
								   name="genderpassenger${ i }"
								   value="F"> Female
						</div>
					</div>
					</c:forEach>
					<br>
					<input type="submit"
						   value="Next">
				
			</form>
	</body>
</html>