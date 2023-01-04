<!DOCTYPE html>
<%@ page language="java"
        contentType="text/html; charset=utf-8"
        pageEncoding="UTF-8"%>
<html>
	<head>
		<meta charset="UTF-8"/>
		<title>Messenger Main Page</title>
	</head>
	<body>
		<h1>Добро пожаловать в мессенджер!<h1>
		<p><a href="${pageContext.request.contextPath}/ui/user/message">Написать сообщение</a></p>
		<p><a href="${pageContext.request.contextPath}/ui/user/chats">Посмотреть отправленные мне сообщения</a></p>
		<p><a href="${pageContext.request.contextPath}/ui/LogOut">Выйти</a></p>
	</body>
</html>
