<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
	<head>
		<title>To Do List </title>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
	</head>
	
	<body>
		<%@ include file="common/header.jspf" %>
		<%@ include file="common/navigation.jspf" %>
		
		<div class="container m-3 p-3">
			<table class="table">
				<thead>
					<thead>
						<th>Task Name</th>
						<th>Description</th>
						<th>Completed by</th>
						<th>is Done? </th>
						<th></th>
						<th></th>
					</thead>
				</thead>
				<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.taskName}</td>
						<td>${todo.description}</td>
						<td>${todo.date}</td>
						<td>${todo.done}</td>
						<td> <a href="delete-todo?id=${todo.id}" class="btn btn-sm btn-warning">delete</a> </td>
						<td> <a href="update-todo?id=${todo.id}" class="btn btn-sm btn-info">update</a> </td>
					</tr>
				</c:forEach>
				</tbody>
			</table>

			<a href="add-todo" class="btn btn-success">add</a>
		</div>
		
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
		
		<%@ include file="common/footer.jspf" %>
	</body>
</html>