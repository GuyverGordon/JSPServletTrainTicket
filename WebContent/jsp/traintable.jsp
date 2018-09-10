<%@ page language="java" 
		 contentType="text/html; charset=ISO-8859-1"
    	 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
		   prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"
		   prefix="f" %>
<%@ page import="model.Train, java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" 
			  content="text/html; charset=ISO-8859-1">
		<title>Train Ticket -- List</title>
		<link rel="stylesheet" 
	  		  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	</head>
	<body class="container">
		<h1 class="text-center"> Trains Available </h1>
		<div class="table-responsive">
			<table border="3px"
				   class="table table-hover table-borderless">
				<tr>
					<th> Train Name </th>
					<th> From </th>
					<th> To </th>
					<th> Ticket Price </th>
					<th></th>
				</tr>
				
				<c:forEach items="${ trains }"
						   var="train">
					<tr>
						<td> ${ train.trainName } </td>
						<td> ${ train.source } </td>
						<td> ${ train.destination } </td>
						
						<td> 
							<f:formatNumber value="${ train.ticketPrice }" 
											type="currency"/> 
						</td>
						
						<td>
							<form action="./SelectTrain"
								  method="post">
								<button name="trainid"
										type="submit" 
										class="btn btn-primary"
										value="${ train.trainNo }"> Select Train </button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</table>
			<a class="btn btn-info" 
			   href="./TrainList"
			   role="button"> Back </a>
		</div>
	</body>
</html>