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
		<title>Ticket Train - Train Request</title>
		<link rel="stylesheet" 
	  		  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	</head>
	<body class="container">
		<h1 class="text-center"> Request Train </h1>
			<form action="./TrainTable"
				  method="post"
				  class="text-center">
				<input list="sources" name="place">
				<datalist id="sources">
					<c:forEach items="${ sources }" 
							   var="source">
						<option value="${ source }"> ${ source } </option>
					</c:forEach>
				</datalist>
				<input type="submit"
					   value="Submit"
					   class="btn btn-primary">
			</form>
	</body>
</html>