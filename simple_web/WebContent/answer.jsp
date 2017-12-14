<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">

</head>
<body>
<div class="container" >
<div class="row">
<h2><%= request.getAttribute("topictitle") %></h1>
</div>
<div class="row">
<h5 ><%= request.getAttribute("topicanswer") %></h2>

</div>
<div class="row">
<form action="Showdata????" method="get">
    <button class = "btn btn-info" type="submit"/>Back to topic list</button>
</form>
</div>

</div>




</body>
</html>