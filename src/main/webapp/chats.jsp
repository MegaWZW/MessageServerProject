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
		<form action="/api/message" method="post">
		    <h1>Сообщения: </h1>
		    <br><br>
			Логин: <input name="login"/>
			<br><br>
			Пароль: <input name="password"/>
			<br><br>
			ФИО: <input name="fio"/>
			<br><br>
			Год рождения: <input name="year" type="number" min=1900 max=2022/>
			<br><br>
			Месяц рождения(цифрой):  <input name="month" type="number" min=1 max=12/>
			<br><br>
			День рождения: <input name="day" type="number" min=1 max=31/>
			<input type="submit" value="Регистрация" />
		</form>
	</body>
</html>