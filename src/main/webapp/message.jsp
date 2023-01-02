<!DOCTYPE html>
<%@ page language="java"
        contentType="text/html; charset=utf-8"
        pageEncoding="UTF-8"%>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>SingUp Page</title>

	</head>
	<body>
		<form action="/api/user" method="get">
		  <h1>Отправка сообщения:</h1>
		  <br><br>
		  Получатель: <input name:"login"/>
		  <br><br>
		  Текст сообщения: <input name="text" maxlength=2000/>
		  <input type="submit" value="Отправить сообщение"/>
		</form>
	</body>
</html>