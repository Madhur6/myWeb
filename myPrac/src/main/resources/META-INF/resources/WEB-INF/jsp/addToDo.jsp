<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
		<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet">
		<title>Add To Do </title>
		
		<style>
		</style>
	</head>
	
	
	<body>
		<%@ include file="common/header.jspf" %>
		<%@ include file="common/navigation.jspf" %>
		
		<div class="p-3">	
			<h4 class="text-center m-3"> Add Your To-Dos ${name} </h4>
			<hr>
			<div class="container m-3 p-3">
				<form:form method="post" modelAttribute="todo">
					
					<fieldset class="mb-3">
						<form:label path="taskName"> Task Name </form:label>
						<form:input type="text" path="taskName" required="required"/>
						<form:errors path="taskName" cssClass="text-warning"/>
					</fieldset>
					
					<fieldset class="mb-3">
						<form:label path="description"> description </form:label>
						<form:input type="text" path="description" required="required"/>
						<form:errors path="description" cssClass="text-warning"/>
					</fieldset>
					
					<fieldset class="mb-3">
						<form:label path="date"> Completion Date </form:label>
						<form:input type="text" path="date" required="required"/>
						<form:errors path="date" cssClass="text-warning"/>
					</fieldset>
					<input type="submit" class="btn btn-success"/>
				</form:form>
			</div>
		</div>
		
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
		<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
		
		<script type="text/javascript">
			$('#date').datepicker({
			    format: 'yyyy-mm-dd'
			});
		</script>
		
		<%@ include file="common/footer.jspf" %>
		
	</body>
</html>