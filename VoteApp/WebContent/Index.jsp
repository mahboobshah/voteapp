<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>VoteApp</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/moment.min.js"></script>
<script src="js/combodate.js"></script>
</head>
<body>

	<nav class="navbar navbar-inverse navbar-static-top">
		<div class="nav-header">

			<a href="#" class="navbar-brand">Vote App</a>

			<button class="navbar-toggle" data-toggle="collapse"
				data-target=".navHeaderCollapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

			<div class="collapse navbar-collapse navHeaderCollapse">

				<ul class="nav navbar-nav navbar-right">

					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">Blog</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">Contact</a></li>

				</ul>

			</div>

		</div>
	</nav>

	<div class="container">

		<div class="jumbotron text-center">
			<h1>Vote App</h1>
			<br>
			<p>Create or Search for a poll</p>
			<a class="btn btn-default" data-toggle="modal" data-target="#create">Create
				Now!</a> <a class="btn btn-info" data-toggle="modal"
				data-target="#search">Search</a>
		</div>

	</div>

	<div class="modal fade" id="search">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="col-md12">
					<form class="form-horizontal text-center" action="SearchController"
						method="get">
						<div class="modal-header">
							<h4>Enter the vote ID you are searching for</h4>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<div class="row">
									<div class="col-lg-6">
										<div class="input-group">
											<input type="text" name="voteID" class="form-control">
											<span class="input-group-btn">
												<button class="btn btn-default" type="submit">Go!</button>
											</span> 
										</div>
										<!-- /input-group -->
									</div>
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="create">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="col-md12">
					<form class="form-horizontal text-center"
						action="CreateVoteController" method="post">
						<div class="modal-header">
							<h4>Poll Information</h4>
						</div>
						<div class="modal-body">

							<div class="form-group">
								<div class="col-md-12">
									<label class="control-label">Enter the poll description
										below</label>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-12">
									<textarea class="form-control" rows="4" cols="50"
										name="voteDesc"></textarea>
								</div>
							</div>
							<div class="form-group">
							
							</div>
							<div class="form-group">
								<div class="col-md-6 pull-left">
									<label class="control-label">Add options for the poll</label>
								</div>
							</div>
							<div class="form-group text-center">

								<div id='TextBoxesGroup'>
									<div id="TextBoxDiv1" class="col-md-8">
										<input type='text' class="form-control"
											id='textbox1' name='optionsData'>
									</div>

								</div>
							</div>
						</div>
 						
						<div class="form-group">
							<div class="col-md-4 pull-right">
								<button type="button" class="btn btn-default" id="addButton">Add Option</button>
							</div>
							<div class="col-md-4 pull-right">
								<button type="button" class="btn btn-default" id="removeButton">Remove Option</button>
							</div>
						</div>

						<div class="modal-footer">
							<a class="btn btn-default" data-dismiss="modal">Close</a>
							<button class="btn btn-primary" type="submit">Create</button>
						</div>
					</form>
				</div>
			</div>
		</div>

	</div>

	<div class="navbar navbar-default navbar-fixed-bottom">

		<div class="container">
			<p class="navbar-text pull-left">Site Developed By Mavericks</p>
		</div>

	</div>

	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>
<!-- 	<script id="js-datetime24">$(function(){$('#datetime24').combodate();});</script> -->
	<script >
	$(window).load(function() {
		$(document).ready(function() {
			var counter = 2;
			$("#addButton").click(function() {
				$('<div/>', {
					'id' : 'TextBoxDiv' + counter,
					'class' : 'col-md-8'
				}).append($('<input type="text" class="form-control">').attr({
					'id' : 'textbox' + counter,
					'name' : 'optionsData'
				})).appendTo('#TextBoxesGroup')
				counter++;
			});

			$("#removeButton").click(function() {
				if (counter == 1) {
					alert("No more textbox to remove");
					return false;
				}
				counter--;
				$("#TextBoxDiv" + counter).remove();
			});
		});
	});
</script>

</body>
</html>