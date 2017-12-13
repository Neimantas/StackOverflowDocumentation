<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<script type="text/javascript" src="showdata.js"></script>
<title>JAVA data</title>
</head>
<body>
<div class="container-fluid" style="margin-top: 20px">
	<label for="usr">Select language</label>
	<div class="form-group">
		<select id="option" class="custom-select">
		  <option value="Java">Java</option>
		  <option value="Csharp">Csharp</option>
		  <option value="JavaScript">JavaScript</option>
		  <option value="Swift">Swift</option>
		</select>
	</div>
	<div class="form-group">
	  <label for="usr">Topic</label>
	  <input type="text" class="form-control" id="topic" style="width:200px">
	</div>
	
	<button class="btn btn-primary" type="button" onclick="sendLanguageAndTopicParameters()">Search</button>
</div>
<br>
<div class="container">
<form action="Showdata" method="get">
<button type="button"  onclick="location.href='Showdata?page=down&currentpage=<%= request.getAttribute("currentpage") %>'"> << </button>

<button type ="button" onclick="location.href='Showdata?page=up&currentpage=<%= request.getAttribute("currentpage") %>'"> >> </button>
</form>
</div>
<div class="container">
	<table class="table table-striped table-inverse">
		<thead>
			<tr>
				<th>Id</th>
				<th>Title</th>
				<th>Answer</th>
				<th>Creation Date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="list" items="${topiclist}">
				<tr>
					<td>${list.id}</td>
					<td>${list.title}</td>
					<td>${list.answer}</td>
					<td>${list.creationDate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<div class="container">
<form action="Showdata" method="get">
<button type="button"  onclick="location.href='Showdata?page=down&currentpage=<%= request.getAttribute("currentpage") %>'"> << </button>

<button type ="button" onclick="location.href='Showdata?page=up&currentpage=<%= request.getAttribute("currentpage") %>'"> >> </button>
</form>
</div>


</body>
</html>