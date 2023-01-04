<!DOCTYPE html>
<%@ page language="java"
        contentType="text/html; charset=utf-8"
        pageEncoding="UTF-8"%>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>Message is delivered</title>
	</head>
	<body>
		<h1>Сообщение отправлено!</h1>
		<p><a href="${pageContext.request.contextPath}/ui/user/message">Написать ещё одно</a></p>
		<p><a href="${pageContext.request.contextPath}/ui/user/chats">Посмотреть отправленные мне сообщения</a></p>
		<p><a href="${pageContext.request.contextPath}/ui">Вернуться на главную страницу</a></p>
		<p><a href="${pageContext.request.contextPath}/ui/LogOut">Выйти</a></p>
	</body>
</html>