<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="login.css">
</head>
<body>
		<div class="center">
          <h1>SignUp</h1>
          <form action="loginForm" method="post">
          	  <div class="txt_field">
                <input type="text" name="fname" />
                <span></span>
              <label>FirstName</label>
              </div>
              <div class="txt_field">
                <input type="text" name="lname" />
                <span></span>
              <label>LastName</label>
              </div>
              <div class="txt_field">
                <input type="text" name="user"/>
                <span></span>
                <label>User</label>
              </div>
              <div class="txt_field">
                <input type="password" name="password"/>
                <span></span>
                <label>Password</label>
              </div>
              <input class="btn" type="submit" value="SignUp" name="submit">
              
              
              <div class="signup_link">
                Already Have An Account?  
                <a class="signup" href="login.jsp">SignIn</a>
              </div>
          </form>
  </div>
</body>
</html>