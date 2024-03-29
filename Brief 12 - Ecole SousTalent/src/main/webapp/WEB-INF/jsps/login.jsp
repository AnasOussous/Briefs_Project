
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Long Leaders</title>
<style type="text/css">
body{
	margin:0;
	color:#6a6f8c;
	background:#c8c8c8;
	font:600 12px/14px "Montserrat-SemiBold";
}

*,:after,:before{box-sizing:border-box}

.ccsticky-nav {
display: flex;
width: 100%;
height: 65px;
position: fixed; 
top: 0;
background-color:#A25B5B;
}

#logo
{
	display:inline;
	color:#f3f3f3;
	font: bold 'roboto';
	font-size: 50px;
	margin-top:20px;
	margin-left:0px;
	 
}
header {
width: 100%;
border-bottom: 1px solid #ccc;
height: 38px;
text-align: left;
}
.center {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	width: 400px;
	height :350px;
	background: white;
	border-radius: 10px;
	box-shadow: 10px 10px 15px rgba(0, 0, 0, 0.05);
}
.center h1 {
	text-align: center;
	padding: 20px 0;
	border-bottom: 1px solid silver;
}
.center form {
	padding: 0 40px;
	box-sizing: border-box;
}
form .txt_field {
	position: relative;
	border-bottom: 2px solid #adadad;
	margin: 30px 0;
}
.txt_field input {
	width: 100%;
	padding: 0 5px;
	height: 40px;
	font-size: 16px;
	border: none;
	background: none;
	outline: none;
}
.txt_field label {
	position: absolute;
	top: 50%;
	left: 5px;
	color: #adadad;
	transform: translateY(-50%);
	font-size: 16px;
	pointer-events: none;
	transition: .5s;
}
.txt_field span::before {
	content: '';
	position: absolute;
	top: 40px;
	left: 0;
	width: 0%;
	height: 2px;
	background: #2691d9;
	transition: .5s;
}
.txt_field input:focus ~ label, .txt_field input:valid ~ label {
	top: -5px;
	color: #A25B5B;
}
.txt_field input:focus ~ span::before, .txt_field input:valid ~ span::before
	{
	width: 100%;
}
input[type="submit"] {
	width: 100%;
	height: 50px;
	border: 1px solid;
	background-color:#A25B5B;
	border-radius: 25px;
	font-size: 18px;
	color: #e9f4fb;
	font-weight: 700;
	cursor: pointer;
	outline: none;
	margin-bottom: 10%;
}
input[type="submit"]:hover {
	border-color: #CC9C75;
	transition: .5s;
}
</style>
</head>
<body>

    
		<div class="center">
		<h1>Login</h1>
		<form method="post" action="Login">
			<div class="txt_field">
				<input type="text" name="loginUser" id="loginUser" required>
				 <label>Username</label>
			</div>
			<div class="txt_field">
				<input type="password" name="loginPass" id="loginPass" required>
			    <label>Password</label>
			</div>
		    <input type="submit" value="log In">
		</form>
	</div>
	
	
	<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
		<h1>Login Form</h1>
		<form action="Login" method="post">

			<div class="form-group">
				<label for="uname">Username</label> 
				<input type="text" class="form-control" id="loginPass" placeholder="User Name" th:field="*{loginPass}"
					name="loginPass" required>
			</div>

			<div class="form-group">
				<label for="uname">Password</label> 
				<input type="password" class="form-control" id="loginPass" placeholder="Password" th:field="*{loginPass}"
					name="loginPass" required>
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
	
</body>
</html>