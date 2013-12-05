<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vote Details</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/styles.css" rel="stylesheet">
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/moment.min.js"></script>
<script src="js/combodate.js"></script>
</head>
<body>



	<div class="container">
		<div class="row">
			<div class="col-md-12">

				<form action="UpdateVoteController" method="post" class="text-center">
				<input type="hidden" name="voteID" value="${voteID}" />
					<h1>${ voteDesc}</h1>
					<c:forEach var="option" items="${options}">
						<div class="col-lg-6">
							<div class="input-group">
								<span class="input-group-addon"> <input type="radio"
									name="chosenOption" value="${option.optionId }" onclick="handleClick(this)">
								</span>
								<div id="opt" class="well well-sm form-control text-left">
									<h6>${option.optionDesc }</h6>
								</div>
							</div>
							<br>
						</div>
					</c:forEach>
					<button class="btn btn-success pull-right" id="voteButton" disabled type="submit">Vote!</button>
				</form>
			</div>
		</div>

	</div>

	<script type="text/javascript">
	function handleClick(myRadio) {
	    $('#voteButton').prop("disabled", false);
	}
	</script>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script src="js/bootstrap.js"></script>

</body>
</html>