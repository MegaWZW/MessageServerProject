package com.mycompany.app.message_server.controllers.web.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "MainPageServlet", urlPatterns = "/ui")
public class MainPageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if(session.getAttribute("user") != null){
			request.getRequestDispatcher("/jsp/main/mainReg.jsp").forward(request, response);
		}else{
			request.getRequestDispatcher("/jsp/main/main.jsp").forward(request, response);
		}

	}
}
