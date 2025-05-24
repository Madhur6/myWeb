<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
	<head>
		<title> List To Do </title>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
	</head>
	<body>
		<%@ include file="common/navigation.jspf" %>
		<div class="container text-center mt-3">
			<h2>To-Do List **${username}**</h2>
			<hr>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>USERNAME</th>
						<th>TASK-NAME</th>
						<th>DESCRIPTION</th>
						<th>DATE</th>
						<th>DONE</th>
						<th>Delete ? </th>
						<th>Update ? </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.id}</td>
						<td>${todo.username}</td>
						<td>${todo.taskName}</td>
						<td>${todo.description}</td>
						<td>${todo.date}</td>
						<td>${todo.done}</td>
						<td><a href="delete-todo?id=${todo.id}" class="btn btn-sm btn-warning">delete</a></td>
						<td><a href="update-todo?id=${todo.id}" class="btn btn-sm btn-info">update</a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<a href="add-todo" class="btn btn-sm btn-success">add</a>
		</div>
		<%@ include file="common/footer.jspf" %>
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
</html>