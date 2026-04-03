<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Bank</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<style type="text/css">
body {
	height: 100vh;
	min-height: 400px;
	background-size: cover;
	background-image:
		url('https://www.wallpapers13.com/wp-content/uploads/2018/12/United-Arab-Emirates-Dubai-Reflection-on-Midnight-4K-Ultra-HD-Desktop-Wallpapers-for-Computers-Laptop-Tablet-And-Mobile-Phones-3840x2400.jpg');
}

.hidden-spacer {
	height: 56px
}
</style>
</head>
<body>

	<nav class="navbar navbar-expand-sm fixed-top navbar-light">
		<div class="container">
			<a class="navbar-brand" href="#">Brand</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbar1">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbar1">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link" href="#">Link</a>
					</li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				</ul>
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="#">Link</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="card" style="width: 18rem;">
			<ul class="list-group list-group-flush">
				<li class="list-group-item"><a class="text-dark"
					href="./deposit/">Deposit</a></li>
				<li class="list-group-item"><a class="text-dark"
					href="./withdraw/">Withdraw</a></li>
				<li class="list-group-item"><a class="text-dark"
					href="./transfer/">Transfer</a></li>
			</ul>
		</div>
	</div>
	<div class="sticky-top bg-white hidden-spacer"></div>
	<div class="container pt-5">
		<div class="row">
			<div class="col-12">
				<div class="card" style="width: 18rem;">
					<ul class="list-group list-group-flush">
						<li class="list-group-item"><a class="text-dark"
							href="./deposit/">Deposit</a></li>
						<li class="list-group-item"><a class="text-dark"
							href="./withdraw/">Withdraw</a></li>
						<li class="list-group-item"><a class="text-dark"
							href="./transfer/">Transfer</a></li>
					</ul>
				</div>
			</div>
		</div>
		<!--/row-->
	</div>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="/">My Bank</a>
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
				<li class="nav-item"><a class="nav-link" href="/firm/">Firms</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/proprietor/">Proprietors</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/account/">Account</a>
				</li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"></a>
					<div class="dropdown-menu dropdown-menu-right"
						aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="/savingsAccount/">Savings
							Accounts</a> <a class="dropdown-item" href="/currentAccount/">Current
							Accounts</a>
					</div></li>
			</ul>
		</div>
	</nav>
	<div class="container"></div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
		crossorigin="anonymous"></script>
</body>
</html>