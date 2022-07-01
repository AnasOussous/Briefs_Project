<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
		 <nav  class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div style="margin-left : 30rem" class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
            <li class="nav-item active">
              <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link ml-5" href="#">Features</a>
            </li>
            <li class="nav-item">
              <a class="nav-link ml-5" href="#">Pricing</a>
            </li>
            <li class="nav-item">
              <a class="nav-link ml-5" href="login.jsp"> Logout</a>
            </li>
          </ul>
          <span style="margin-left : 20rem" class="navbar-text">
		      Hi ${message} Welcome
		  </span>
        </div>
      </nav>

	
</body>
</html>