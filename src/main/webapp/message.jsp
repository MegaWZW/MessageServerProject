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
		<form action="${pageContext.request.contextPath}/api/message" method="post">
		  <h1>Отправка сообщения:</h1>
		  <br><br>
		  Получатель: <input name="to"/>
		  <br><br>
		  Текст сообщения: <input name="text" maxlength=2000/>
		  <input type="submit" value="Отправить сообщение"/>
		</form>
		<p><a href="${pageContext.request.contextPath}/ui">Вернуться на главную страницу</a></p>
		<p><a href="${pageContext.request.contextPath}/ui/LogOut">Выйти</a></p>
	</body>
</html>