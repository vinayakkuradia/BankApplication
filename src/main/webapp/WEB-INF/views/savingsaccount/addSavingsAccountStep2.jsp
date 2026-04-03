<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Savings Account</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
</head>
<body>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="/home">My Bank</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarScroll" aria-controls="navbarScroll"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarScroll">
			<ul class="navbar-nav ml-auto my-2 my-lg-0 navbar-nav-scroll"
				style="max-height: 100px;">
				<li class="nav-item"><a class="nav-link" href="/transaction/">Transactions
				</a></li>
				<li class="nav-item"><a class="nav-link" href="/customer/">Customers</a>
				</li>
				<li class="nav-item active"><a class="nav-link"
					href="/savingsAccount/">Savings Accounts</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/logout">Logout</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<h3 class="mt-5">Enter savings account info and verify customer
			details:</h3>
		<hr />
		<form:form action="addSavingsAccountStep2" method="post"
			modelAttribute="savingsAccount">
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<form:label path="accountBalance">Initial Account Balance: </form:label>
					<form:input class="form-control" path="accountBalance" />
					<small><form:errors path="accountBalance"
							class="text-danger" /></small>
				</div>
			</div>

			<form:hidden path="accountOwner.customerId" />
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<form:label path="accountOwner.customerName.firstName">First Name: </form:label>
					<form:input class="form-control" path="accountOwner.customerName.firstName"
						readonly="true" />
				</div>
				<div class="col-md-4 mb-3">
					<form:label path="accountOwner.customerName.middleName">Middle Name: </form:label>
					<form:input class="form-control" path="accountOwner.customerName.middleName"
						readonly="true" />
				</div>
				<div class="col-md-4 mb-3">
					<form:label path="accountOwner.customerName.lastName">Last Name: </form:label>
					<form:input class="form-control" path="accountOwner.customerName.lastName"
						readonly="true" />
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<form:label path="accountOwner.customerSex">Sex: </form:label>
					<form:input class="form-control" path="accountOwner.customerSex"
						readonly="true" />
				</div>
				<div class="col-md-4 mb-3">
					<form:label path="accountOwner.dateOfBirth">Date of Birth: </form:label>
					<form:input class="form-control" type="date" path="accountOwner.dateOfBirth"
						readonly="true" />
				</div>
				<div class="col-md-4 mb-3">
					<form:label path="accountOwner.mobileNumber">Mobile Number: </form:label>
					<form:input class="form-control" path="accountOwner.mobileNumber" readonly="true" />
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-4 mb-3">
					<form:label path="accountOwner.customerData.aadhaarNumber">Aadhaar Number: </form:label>
					<form:input class="form-control" path="accountOwner.customerData.aadhaarNumber"
						readonly="true" />
				</div>
				<div class="col-md-4 mb-3">
					<form:label path="accountOwner.customerData.panNumber">PAN Number: </form:label>
					<form:input class="form-control" path="accountOwner.customerData.panNumber"
						readonly="true" />
				</div>
			</div>

			<form:hidden
				path="accountOwner.customerData.customerAddress.houseNumber" />
			<form:hidden
				path="accountOwner.customerData.customerAddress.locality" />
			<form:hidden
				path="accountOwner.customerData.customerAddress.landmark" />
			<form:hidden path="accountOwner.customerData.customerAddress.city" />
			<form:hidden
				path="accountOwner.customerData.customerAddress.district"
				items="${districts}" />
			<form:hidden path="accountOwner.customerData.customerAddress.state"
				items="${states}" />
			<form:hidden path="accountOwner.customerData.customerAddress.pinCode" />

			<div class="form-row">
				<div class="col-md-1 mb-3">
					<input class="form-control" type="submit" />
				</div>
			</div>
		</form:form>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
		crossorigin="anonymous"></script>
</body>
</html>