<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="sources/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="sources/js/own/validTest.js"></script>

</head>
<body>
<form action="/test/valid" method="post">
	name:<input name="name" id="name" /><br />
	age:<input name="age" id="age"/><br />
	<input type="button" value="submit" id="submit" />
</form>
</body>
</html>