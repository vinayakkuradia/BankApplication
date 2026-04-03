<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error 500: Not Found</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
	<style type="text/css">
	* {
  margin: 0;
  padding: 0;
}

a {
  text-decoration: none;
}

body {
  font-weight: 600;
  color: #343434;
}

.error_section {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  height: 100vh;
  background-image: linear-gradient(-225deg, #1A1A1A, #343434);
}
.error_section_subtitle {
  color: #25F193;
  text-transform: uppercase;
  letter-spacing: 5pt;
  font-weight: 500;
  font-size: 0.8rem;
  margin-bottom: -5em;
}
.error_section .error_title {
  --x-shadow: 0;
  --y-shadow: 0;
  --x:50%;
  --y:50%;
  font-size: 15rem;
  transition: all 0.2s ease;
  position: relative;
  padding: 2rem;
}
.error_section .error_title:hover {
  transition: all 0.2s ease;
  text-shadow: var(--x-shadow) var(--y-shadow) 10px #1A1A1A;
}
.error_section .error_title p {
  position: absolute;
  top: 2rem;
  left: 2rem;
  background-image: radial-gradient(circle closest-side, rgba(255, 255, 255, 0.05), transparent);
  background-position: var(--x) var(--y);
  background-repeat: no-repeat;
  text-shadow: none;
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  transition: all 0.1s ease;
}

.btn {
  padding: 0.8em 1.5em;
  border-radius: 99999px;
  background-image: linear-gradient(to top, #03A9F4, #00BCD4);
  box-shadow: 0px 2px 5px 0px rgba(0, 0, 0, 0.2), inset 0px -2px 5px 0px rgba(0, 0, 0, 0.2);
  border: none;
  cursor: pointer;
  text-shadow: 0px 1px #343434;
  color: white;
  text-transform: uppercase;
  letter-spacing: 1.5pt;
  font-size: 0.8rem;
  font-weight: 700;
  transition: ease-out 0.2s all;
}
.btn:hover {
  text-shadow: 0px 1px 1px #ffffff;
  transform: translateY(-5px);
  box-shadow: 0px 4px 15px 2px rgba(0, 0, 0, 0.1), inset 0px -3px 7px 0px rgba(0, 0, 0, 0.2);
  transition: ease-out 0.2s all;
}
	
	</style>
</head>
<body>
	 <section class="error_section">
      <p class="error_section_subtitle">Opps Page is not available !</p>
      <h1 class="error_title">
        <p>500</p>
        500
      </h1>
      <a href="#" class="btn">Back to home</a>
    </section>
	<script>
	const title = document.querySelector('.error_title')


////////Light //////////
document.onmousemove = function(e) {
let x = e.pageX - window.innerWidth/2;
let y = e.pageY - window.innerHeight/2;

title.style.setProperty('--x', x + 'px')
title.style.setProperty('--y', y + 'px')
}

//////////////Shadow ///////////////////
title.onmousemove = function(e) {
let x = e.pageX - window.innerWidth/2;
let y = e.pageY - window.innerHeight/2;

let rad = Math.atan2(y, x).toFixed(2); 
let length = Math.round(Math.sqrt((Math.pow(x,2))+(Math.pow(y,2)))/10); 

let x_shadow = Math.round(length * Math.cos(rad));
let y_shadow = Math.round(length * Math.sin(rad));

title.style.setProperty('--x-shadow', - x_shadow + 'px')
title.style.setProperty('--y-shadow', - y_shadow + 'px')

}
	</script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
		crossorigin="anonymous"></script>
</body>
</html>