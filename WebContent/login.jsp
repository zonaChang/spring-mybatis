<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta content="charset=UTF-8">
<script type="text/javascript" src="sources/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#downLoad").click(function(){
			window.location.href = "http://localhost:8080/file/operate/download";
		});
	})
</script>
<title>登录</title>
</head>
<body>
<form action="/test/mappingtestmethod" method="post">
	name:<input name="name" /><br />
	password:<input name="password" type="password"/><br />
	<input type="submit" value="submit" />
</form>

<br />
<br />
<img src="sources/images/0.jpg" />
<br />
<img alt="" src="sources/images/img1.jpg">
<br />
<br />
<br />
<button id="downLoad">下载文件</button>

</body>
</html>