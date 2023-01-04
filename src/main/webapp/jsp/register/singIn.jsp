<!DOCTYPE html>
<%@ page language="java"
        contentType="text/html; charset=utf-8"
        pageEncoding="UTF-8"%>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>SingIn Page</title>

	</head>
	<body>
		<form action="${pageContext.request.contextPath}/api/login" method="post">
		    <h1>Вход: </h1>
		    <br><br>
		    Логин : <input name="login"/>
		    <br><br>
		    Пароль: <input name="password"/>
		    <input type="submit" value="Вход" />
		</form>
	</body>
</html>