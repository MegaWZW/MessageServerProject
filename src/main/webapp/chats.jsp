<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.time.format.DateTimeFormatter" %>

<html>
    <head>
		<meta charset="UTF-8"/>
		<title>Your messages</title>
    </head>
    <body>
        <h1>Сообщения для пользователя: "${receiver.dto.login}"</h1>
        <br><br>
        <c:forEach items="${messages}" var="item">
            <p>${item.dtAcceptance.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))} от
             ${item.message.from.dto.login}: ${item.message.text}</p>
        </c:forEach>
        <p><a href="/message_server-1.0.0/ui/user/message">Написать сообщение</a></p>
        <p><a href="/message_server-1.0.0/ui">Вернуться на главную страницу</a></p>
        <p><a href="/message_server-1.0.0/ui/LogOut">Выйти</a></p>
    </body>
</html>