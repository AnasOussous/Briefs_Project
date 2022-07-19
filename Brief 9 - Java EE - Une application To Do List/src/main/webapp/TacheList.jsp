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

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Tache</h3>
			<hr>
			<div class="container text-left">

				<a href="AddTache.jsp"
					class="btn btn-success">Add Tache</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Title</th>
						<th>Deadline</th>
						<th>Todo Status</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="tache" items="${TacheList}">

						<tr>
							<td><c:out value="${tache.title}" /></td>
							<td><c:out value="${tache.deadline}" /></td>
							<td><c:out value="${tache.statue}" /></td>

							<td><a href="edit?id=<c:out value='${tache.id_tache}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?id=<c:out value='${tache.id_tache}' />">Delete</a></td>

							<!--  <td><button (click)="updateTodo(todo.id)" class="btn btn-success">Update</button>
          							<button (click)="deleteTodo(todo.id)" class="btn btn-warning">Delete</button></td> -->
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>