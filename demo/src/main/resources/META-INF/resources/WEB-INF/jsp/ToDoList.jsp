<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
	<head>
		<title> To-Do LIST </title>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="container m-3 p-3">
			<h1> To Do List </h1>
			<table class="table">
				<thead>
					<th>Username</th>
					<th>TaskName</th>
					<th>Description</th>
					<th>Date</th>
					<th>Done</th>
				</thead>
				
				<tbody>
					<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.userName}</td>
						<td>${todo.taskName}</td>
						<td>${todo.description}</td>
						<td>${todo.date}</td>
						<td>${todo.done}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="/add-todo" class="btn btn-sm btn-success">Add</a>		
		</div>
		
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>	
</html>