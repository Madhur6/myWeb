<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
	<head>
		<title>
			Add To-Do page
		</title>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
		<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet">

	</head>
	<body>
		<%@ include file="common/navigation.jspf" %>
		<div class="container text-center mt-3">
			<h2> Add to-do page </h2>
			
			<div class="container card d-flex flex-column align-items-center justify-content-center p-3">
				<form:form method="POST" class="card shadow m-3 p-3" modelAttribute="todo">
					
					<div class="d-flex flex-column align-items-center m-1 form-group">
						<label for="taskName" class="m-2" style="width:110px">Task-Name &#x2B07 </label>
						<form:input type="text" autocomplete="new-password" cssClass="form-control" style="width:250px" path="taskName" name="taskName" placeholder="Enter your task" required="required"/>
						<div>
							<form:errors path="taskName" cssClass="text-warning"/>
						</div>
					</div>
					
					<div class="d-flex flex-column align-items-center m-1 form-group">
							<label for="description" class="m-2" style="width:90px">Describe &#x2B07</label>
						<form:input type="text" autofocus="autofocus" autocomplete="new-password" cssClass="form-control" style="width:250px" path="description" name="description" placeholder="description" required="required"/>
						<div>
							<form:errors path="description" cssClass="text-warning"/>
						</div>
					</div>
					

					
					<div class="d-flex flex-column align-items-center m-1 form-group">
						<label for="date" class="m-2" style="width:90px">Date &#x2B07 </label>
						<form:input type="text" id="date" path="date" style="width:250px" cssClass="form-control" name="date" required="required"/>
						<div>
							<form:errors path="date" cssClass="text-warning"/>
						</div>
					</div>
					<input type="submit" class="btn btn-sm btn-success mt-3">
					<div class="form-group">
					</div>
				</form:form>
			</div>
		</div>
		<%@ include file="common/footer.jspf" %>
		
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
		<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
		<script type="text/javascript">
			$('#date').datepicker({
				format:'yyyy-mm-dd',
				startDate:'0d',
				autoClose:true,
				todayHighlight:true
			});
		</script>
	</body>
</html>