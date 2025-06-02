<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
		<title> To-Do LIST </title>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
	</head>
	<body>
		<div class="container m-3 p-3">
			<h3>Add To Do</h3>
			
			<form:form method="POST" modelAttribute="todo">
				<fieldset class="mb-3">
					<form:label path="taskName">Task Name</form:label>
					<form:input type="text" path="taskName" required="required" autofocus="autofocus"/>
					<form:errors path="taskName" cssClass="text-warning"/>
					
					<form:label path="description">Description</form:label>
					<form:input type="text" path="description" required="required"/>
					<form:errors path="description" cssClass="text-warning"/>
					
					<form:label path="date">Date</form:label>
					<form:input type="date" path="date" required="required"/>
					<form:errors path="date" cssClass="text-warning"/>
				</fieldset>	
			
				<input type="submit" class="btn btn-sm btn-success">
			</form:form>
		</div>
		
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>	
</html>