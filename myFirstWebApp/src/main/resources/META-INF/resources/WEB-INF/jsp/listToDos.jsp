<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
	<head>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
		<title>List Todos Page</title>		
	</head>
	<body>
		<%@ include file="common/header.jspf"%>
		<%@ include file="common/navigation.jspf"%>
		
		<div class="container">
			<h1>Your Todos</h1>
			
			
			<table class="table">
				<thead>
					<tr>
						<th>id</th>
						<th>Description</th>
						<th>Target Date</th>
						<th>Is Done?</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>		
					<c:forEach items="${todos}" var="todo">
						<tr>
							<td>${todo.id}</td>
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.done}</td>
							<td> <a href="delete-todo?id=${todo.id}" class="btn btn-sm btn-warning">delete ${todo.id}</a> </td>
							
							<td> <a href="update-todo?id=${todo.id}" class="btn btn-sm btn-success"> update ${todo.id} </a> </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

			<a href="add-todo" class="btn btn-success">Add Todo</a>
			
		</div>
		<%@ include file="common/footer.jspf" %>
		

		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
</html>