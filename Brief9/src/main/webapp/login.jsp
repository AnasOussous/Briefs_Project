<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
	String U = (String) request.getAttribute("user");
	String p = (String) request.getAttribute("password");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="login.css">
</head>
<body>
	 <div class="center">
          <h1>SignIn</h1>
          <form action="loginForm" method="post">
        	<h3>${message}</h3>
        	<h3>${SMessage}</h3>
              <div class="txt_field">
                <input type="text" name="user"/>
                <span></span>
                <label>Email</label>
              </div>
              <div class="txt_field">
                <input type="password" name="password"/>
                <span></span>
                <label>Password</label>
              </div>
              
              <input class="btn" type="submit" value="login" name="submit">
              <div class="signup_link">
                Already Have An Account?  
                <a class="signup" href="SignUp.jsp">SignUp</a>
              </div>
          </form>
          
  </div>
</body>
</html>