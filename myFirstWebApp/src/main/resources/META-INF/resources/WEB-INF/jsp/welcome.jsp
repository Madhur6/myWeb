<html>
	<head>
		<title> Login Page </title>
	</head>
	<body>
		<%@ include file="common/header.jspf" %>
		<%@ include file="common/navigation.jspf" %>
		
		Welcome to homepage ${name}!
		<div class="container">
			<h1>Welcome ${name}</h1>
			<a href="list-todos">Manage</a> your todos
		</div>
		
		<%@ include file="common/footer.jspf" %>s
 	</body>
</html>