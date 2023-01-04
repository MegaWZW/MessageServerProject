<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
    <head>
		<meta charset="UTF-8"/>
		<title>Statistics</title>
    </head>
    <body>
        <h1>Статистика:</h1>
        <br><br>
        <p>Количество зарегистрированных пользователей: <c:out value="${result.usersAmount}" /></p>
        <p>Количество активных пользователей: <c:out value="${result.usersOnline}" /></p>
        <p>Количество отправленных в приложении сообщений:  <c:out value="${result.messagesAmount}" /></p>
        <br><br>
        <p><a href="${pageContext.request.contextPath}/ui">Вернуться на главную страницу</a></p>

    </body>
</html>