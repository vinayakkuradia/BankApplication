<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Savings Account List</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
</head>
<body style="overflow-x: hidden;">
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
	<h3 class="mt-5">All savings account:</h3>
	<hr />
	<table class="table table-hover">
		<thead class="thead-dark">
			<tr>
				<th scope="col">accountNumber</th>
				<th scope="col">accountActiveStatus</th>
				<th scope="col">accountBalance</th>
				<th scope="col">accountCreationDate</th>
				<th scope="col">Customer Id</th>
				<th scope="col">Account Owner</th>
				<th scope="col">Mobile No.</th>
				<th scope="col">Transactions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${savingsAccounts}" var="savingsAccount">
				<tr>
					<td>${savingsAccount.accountNumber}</td>
					<td>${savingsAccount.accountActiveStatus}  
					<sec:authorize access="hasAnyRole('ADMIN')">
					<a href="./changeActiveStatus?accountNumber=${savingsAccount.accountNumber}" >change</a>
					</sec:authorize></td>
					<td>${savingsAccount.accountBalance}</td>
					<td><fmt:formatDate value="${savingsAccount.accountCreationDate}" pattern="dd-MM-yyyy" /></td>
					<td>${savingsAccount.accountOwner.customerId}</td>
					<td>${savingsAccount.accountOwner.customerName}</td>
					<td>${savingsAccount.accountOwner.mobileNumber}</td>
					<td class="form-row"><a class="btn btn-light btn-sm" href="/transaction/transactionsByAccount?accountNumber=${savingsAccount.accountNumber}">Transactions</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a class="btn btn-dark btn-sm" href="addSavingsAccount">Add Savings Account</a>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
		crossorigin="anonymous"></script>
</body>
</html>