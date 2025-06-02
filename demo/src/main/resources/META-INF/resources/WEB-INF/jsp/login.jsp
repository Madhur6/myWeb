<html>
	<head>
		<title> Login </title>
		<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
		<link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet">
	</head>
	<body>
		<h1> Welcome to my login page </h1>
		<form method="post">
			Name: <input type="text" name="name">
			Password: <input type="password" name="password">
			<input type="submit">
		</form>
	</body>	
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
</html>