<html>
	
	<head>
		<title>Login Page</title>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >

	</head>	
	
	<body>
		<%@ include file="common/header.jspf" %>
		<div class="container text-center mt-3">
			<h3>Welcome to the login page, ${name}! </h3>
			<div class="container card  d-flex flex-column justify-content-center align-items-center ">
				<pre>${errorMessage}</pre>
				<form method="POST" class="form-group">
					<div class="mb-3 d-flex align-items-center form-group">
						<label for="name" class="me-2 mb-0" style="width:70px">name</label>
						<input placeholder="name" type="text" name="name" style="width:250px" class="form-control" name="name">
					</div>
					
					<div class="mb-3 d-flex align-items-center form-group">
						<label for="password" class="me-2 mb-0" style="width:71px">password</label>
						<input placeholder="password" type="text" style="width:250px" name="password" class="form-control" name="name">
					</div>
				
					<input type="submit" name="submit" class="btn btn-sm btn-success mt-3">
				</form>
			</div>			
		</div>
		<%@ include file="common/footer.jspf" %>
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
</html>