<html>
	<head>
		<title> Login Page </title>
	</head>
	<body>
		<%@ include file="common/header.jspf" %>
		<%@ include file="common/navigation.jspf" %>
		
		<div class="text-center">
			<h3> Hi ${name}!, Welcome to the page. </h3>
			<hr>

			<div class="container">
				<a href="list-todo" class="btn btn-sm btn-warning"> Manage your To-Do </a>
			</div>
		</div>

		<%@ include file="common/footer.jspf" %>
 	</body>
</html>