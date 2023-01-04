package com.mycompany.app.message_server.controllers.web.servlets;

import com.mycompany.app.message_server.core.dto.RegisteredUserDTO;
import com.mycompany.app.message_server.core.dto.StatisticsResultDTO;
import com.mycompany.app.message_server.service.api.IStatisticsService;
import com.mycompany.app.message_server.service.factories.StatisticsServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "StatisticsServlet", urlPatterns = "/api/admin/statistics")
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
		request.setAttribute("result", result);
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null){
			throw new IllegalArgumentException("Для доступа по этому адресу необходимо быть авторизованным");
		}
		RegisteredUserDTO currentUser = (RegisteredUserDTO) session.getAttribute("user");

		if(currentUser.isIdAdmin()){
			request.getRequestDispatcher("/jsp/statistics/statistics.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/jsp/response/accessDenied.jsp").forward(request, response);
		}


	}
}
