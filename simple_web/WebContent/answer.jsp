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
<div class="container">
<h1>Topic name: <%= request.getAttribute("topictitle") %></h1>
<h2 ><%= request.getAttribute("topicanswer") %></h2>
</div>
<form action="ShowExample????" method="get">
    <input type="submit" value="Show examples"/>
</form>

<form action="Showdata????" method="get">
    <input type="submit" value="Back to topic list"/>
</form>

</body>
</html>