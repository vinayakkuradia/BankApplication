<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Customer Details</title>
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
				<li class="nav-item active"><a class="nav-link" href="/customer/">Customers</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="/savingsAccount/">Savings Accounts</a></li>
				<li class="nav-item"><a class="nav-link"
					href="/logout">Logout</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<h3 class="mt-5">Enter customer details:</h3>
		<hr />
		<div class="container">
			<form:form action="" method="post" modelAttribute="customer">
				<form:hidden path="customerId" />
				<sec:authorize access="hasAnyRole('ADMIN')">
					<div class="form-row">
						<div class="col-md-4 mb-3">
							<form:label path="customerName.firstName">First Name: </form:label>
							<form:input class="form-control" path="customerName.firstName" />
							<small><form:errors path="customerName.firstName"
									class="text-danger" /></small>
						</div>
						<div class="col-md-4 mb-3">
							<form:label path="customerName.middleName">Middle Name: </form:label>
							<form:input class="form-control" path="customerName.middleName" />
							<small><form:errors path="customerName.middleName"
									class="text-danger" /></small>
						</div>
						<div class="col-md-4 mb-3">
							<form:label path="customerName.lastName">Last Name: </form:label>
							<form:input class="form-control" path="customerName.lastName" />
							<small><form:errors path="customerName.lastName"
									class="text-danger" /></small>
						</div>
					</div>
					<br />
					<div class="form-row">
						<div class="col-md-4 mb-3">
							<form:label path="customerSex">Sex: </form:label>
							<form:select class="form-control" path="customerSex"
								items="${sexTypes}" />
						</div>
						<div class="col-md-4 mb-3">
							<form:label path="dateOfBirth">Date of Birth: </form:label>
							<fmt:formatDate value="${dateOfBirth}" pattern="yyyy-MM-dd"
								var="myDate" />
							<form:input class="form-control" type="date" path="dateOfBirth"
								id="bar" value="${myDate}" />
							<small><form:errors path="dateOfBirth"
									class="text-danger" /></small>
						</div>
						<div class="col-md-4 mb-3">
							<form:label path="mobileNumber">Mobile Number: </form:label>
							<form:input class="form-control" path="mobileNumber" />
							<small><form:errors path="mobileNumber"
									class="text-danger" /></small>
						</div>
					</div>
					<br />
					<div class="form-row">
						<div class="col-md-6 mb-3">
							<form:label path="customerData.aadhaarNumber">Aadhaar Number: </form:label>
							<form:input class="form-control"
								path="customerData.aadhaarNumber" />
							<small><form:errors path="customerData.aadhaarNumber"
									class="text-danger" /></small>
						</div>
						<div class="col-md-6 mb-3">
							<form:label path="customerData.panNumber">PAN Number: </form:label>
							<form:input class="form-control" style="text-transform:uppercase"
								path="customerData.panNumber" />
							<small><form:errors path="customerData.panNumber"
									class="text-danger" /></small>
						</div>
					</div>
					<br />
				</sec:authorize>

				<sec:authorize access="hasAnyRole('USER')">
					<form:hidden path="customerName.firstName" />
					<form:hidden path="customerName.middleName" />
					<form:hidden path="customerName.lastName" />
					<form:hidden path="customerSex" items="${sexTypes}" />
					<form:hidden path="dateOfBirth" />
					<form:hidden path="mobileNumber" />
					<form:hidden path="customerData.aadhaarNumber" />
					<form:hidden path="customerData.panNumber" />
				</sec:authorize>


				<div class="form-row">
					<div class="col-md-2 mb-3">
						<form:label path="customerData.customerAddress.houseNumber">House Number: </form:label>
						<form:input class="form-control" style="text-transform:uppercase"
							path="customerData.customerAddress.houseNumber" />
						<small><form:errors
								path="customerData.customerAddress.houseNumber"
								class="text-danger" /></small>
					</div>
					<div class="col-md-4 mb-3">
						<form:label path="customerData.customerAddress.locality">Locality: </form:label>
						<form:input class="form-control"
							path="customerData.customerAddress.locality" />
						<small><form:errors
								path="customerData.customerAddress.locality" class="text-danger" /></small>
					</div>
					<div class="col-md-4 mb-3">
						<form:label path="customerData.customerAddress.landmark">Landmark: </form:label>
						<form:input class="form-control"
							path="customerData.customerAddress.landmark" />
						<small><form:errors
								path="customerData.customerAddress.landmark" class="text-danger" /></small>
					</div>

					<div class="col-md-2 mb-2">
						<form:label path="customerData.customerAddress.city">City: </form:label>
						<form:input class="form-control"
							path="customerData.customerAddress.city" />
						<small><form:errors
								path="customerData.customerAddress.city" class="text-danger" /></small>
					</div>
				</div>
				<br />
				<div class="form-row">

					<div class="col-md-4 mb-3">
						<form:label path="customerData.customerAddress.district">District: </form:label>
						<form:select class="form-control"
							path="customerData.customerAddress.district" items="${districts}" />
						<small><form:errors
								path="customerData.customerAddress.district" class="text-danger" /></small>
					</div>
					<div class="col-md-4 mb-3">
						<form:label path="customerData.customerAddress.state">State: </form:label>
						<form:select class="form-control"
							path="customerData.customerAddress.state" items="${states}" />
						<small><form:errors
								path="customerData.customerAddress.state" class="text-danger" /></small>
					</div>

					<div class="col-md-4 mb-3">
						<form:label path="customerData.customerAddress.pinCode">PIN Code: </form:label>
						<form:input class="form-control"
							path="customerData.customerAddress.pinCode" />
						<small><form:errors
								path="customerData.customerAddress.pinCode" class="text-danger" /></small>
					</div>
				</div>
				<br />
				<div class="form-row">
					<div class="col-md-1 mb-3">
						<input class="form-control" type="submit" />
					</div>
				</div>
			</form:form>
		</div>
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