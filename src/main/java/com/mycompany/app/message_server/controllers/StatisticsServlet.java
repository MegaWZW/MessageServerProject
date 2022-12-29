package com.mycompany.app.message_server.controllers;

import com.mycompany.app.message_server.core.dto.StatisticsResultDTO;
import com.mycompany.app.message_server.service.api.IStatisticsService;
import com.mycompany.app.message_server.service.factories.StatisticsServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "StatisticsServlet", urlPatterns = "/api/amin/statistics")
public class StatisticsServlet extends HttpServlet {

	private final IStatisticsService statisticsService;

	public StatisticsServlet(){
		this.statisticsService = StatisticsServiceSingleton.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{

		request.setCharacterEncoding("UTF-8");
		StatisticsResultDTO result = statisticsService.getResult();
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("<h1>" + "Статистика: " + "</h1>");
		out.write("<br>" + "<p>" + "Количество зарегестрированных пользователей: " + result.getUsersAmount()
		+ "</p>" + "<br>" + "<p>" + "Количетсво активных пользователей: " + result.getUsersOnline() + "</p>" +
				"<br>" + "<p>" + "Количество отправленных в приложении сообщений: " + result.getMessagesAmount() + "</p>");
	}
}
