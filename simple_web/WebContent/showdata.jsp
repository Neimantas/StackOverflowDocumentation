<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="showdata.js"></script>

<title>JAVA data</title>
</head>
<body>
	<form method="post" action="Showdata">
	<div class="container" style="margin-top: 20px">
	
			<div class="row">
				<div class="col-3">
					<label for="usr">Select language</label>
				</div>
				<div class="col-3">
					<div class="form-group">

						<select name="language" id="option" class="custom-select">
							<option value="Java">Java</option>
							<option value="Csharp">Csharp</option>
							<option value="JavaScript">JavaScript</option>
							<option value="Swift">Swift</option>
						</select>


					</div>
				</div>
				<div class="col-3">
					<button class="btn" style="background-color: #C71585; color: white"
						type="submit">Search</button>

				</div>
			</div>

			<div class="row">
				<div class="col-3">
					<label for="usr">Search topic by tag</label>
				</div>
				<div class="col-3">
					<input name="topic" type="text" class="form-control" id="topic"
						style="width: 200px"> <input type="hidden" name="loadPage"
						value="true" />

				</div>
				<div class="col-3"></div>
			</div>
	</div>
	<br>

</form>
<form action="Showdata" method="get">
	<div class="container">

		<button class="btn btn-info" type="button" 
			onclick="pagination(<%=request.getAttribute("currentpage")%>, 'down')">&#60;&#60;</button>

		<button class="btn btn-info" type="button"
			 onclick="pagination(<%=request.getAttribute("currentpage")%>, 'up')">>></button>

	</div>
	</form>
	<div class="container">
		<table class="table table-striped table-inverse">
			<thead>
				<tr>
					<th>Id</th>
					<th>Title</th>
					<th>Creation Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${filteredTopicsList}">
					<tr>
						<td>${list.getId()}</td>
						<td id="${list.id}" onclick="passid(this.id)"><a href="#">
								${list.getTitle()} </a></td>
						<td>${list.getCreationDate()}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container">
	
	<%=request.getAttribute("currentpage")%>

		<button class="btn btn-info" type="button" 
			onclick="pagination(<%=request.getAttribute("currentpage")%>, 'down')">&#60;&#60;</button>

		<button class="btn btn-info" type="button"
			 onclick="pagination(<%=request.getAttribute("currentpage")%>, 'up')">>></button>
		
		
	</div>
	<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>

	<script type="text/javascript" src="showdata.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
		function passid(id) {

			location.href = 'Answer?topicid=' + id;
		}
	</script>


</body>
</html>