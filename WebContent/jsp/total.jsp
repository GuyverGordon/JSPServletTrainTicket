<%@ page language="java" 
		 contentType="text/html; charset=ISO-8859-1"
    	 pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
		   prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"
		   prefix="f" %>
<%@ page import="model.*, java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Train Ticket -- price</title>
		<link rel="stylesheet" 
	  		  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
		<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
		<script src="js/total.js"></script>
	</head>
	<body class="container">
		<c:set var="ticket"
			   scope="session"
			   value="${ ticket }"/>
		<c:set var="passCount"
			   scope="session"
			   value="${ passengercount }"/>
		<c:set var="fare"
			   scope="session"
			   value="${ fares }"/>
			   
		<table class="table table-hover">
			
			<c:set var="i" 
				   value="1"/>
			<c:forEach var="passenger" 
					   items="${ ticket.passengers }"
					   varStatus="j">
				<tr>
					
					<td> Passenger ${ i }: </td>
					<td> <c:out value="${ passenger.name }"></c:out> </td>
					<c:set var="passFare" 
						   value="${ fare[j.index] }"/>
					<td> 
						<f:formatNumber value="${ passFare }"
										type="currency"/>
					</td>
				</tr>
				<c:set var="i" 
					   value="${ i + 1 }"/>
			</c:forEach>
			<tr>
				<td> TotalPrice: </td>
				<td></td>
				<td> 
					<f:formatNumber value="${ ticket.totalAmount }"
									type="currency"/> 
				</td>
			</tr>
		</table>
		<h3> Please enter your credit card information </h3>
		<form action="./Order" 
			  method="post"
			  id="creditForm">
			Credit Card number:
			<div class="form-row">
				<div class="col">
					<input type="text"
						   name="creditno"
						   class="form-control"
						   pattern="\d{16,}"
						   maxlength="16"
						   title="Must contain 16 numbers"
						   required>
				</div>
				<div class="col">
					<input type="number"
						   name="monthExp"
						   class="form-control"
						   id="monthExp"
						   min="1"
						   max="12"
						   placeholder="Expiration: Month"
						   required>
				</div>
				<div class="col">
					<input type="number"
						   name="yearExp"
						   id="yearExp"
						   class="form-control"
						   placeholder="Expiration: Year"
						   required>
				</div>
				<div class="col">
					<input type="submit"
						   class= "btn btn-primary"
						   value="Complete Order">
				</div>
			</div>
		</form>
	</body>
</html>