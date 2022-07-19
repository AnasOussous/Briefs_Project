<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand"> Todo
					App</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Tache</a></li>
			</ul>

			<ul class="navbar-nav navbar-collapse justify-content-end">
				<li><a href="Login.jsp"
					class="nav-link">Logout</a></li>
			</ul>
		</nav>
	</header>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${tache != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${tache == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${tache != null}">
            			Edit Todo
            		</c:if>
						<c:if test="${tache == null}">
            			Add New Todo
            		</c:if>
					</h2>
				</caption>

				<c:if test="${tache != null}">
					<input type="hidden" name="id" value="<c:out value='${tache.id_tache}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Todo Title</label> <input type="text"
						value="<c:out value='${tache.title}' />" class="form-control"
						name="title" required="required" minlength="5">
				</fieldset>

				<fieldset class="form-group">
					<label>Todo Decription</label> <input type="text"
						value="<c:out value='${tache.description}' />" class="form-control"
						name="description">
				</fieldset>

				<fieldset class="form-group">
					<label>Todo Status</label> 
					
					<input type="text"
						value="<c:out value='${tache.statue}' />" class="form-control"
						name="statue">
				</fieldset>

				<fieldset class="form-group">
					<label>Deadline</label> <input type="date"
						value="<c:out value='${tache.deadline}' />" class="form-control"
						name="deadline" required="required">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>