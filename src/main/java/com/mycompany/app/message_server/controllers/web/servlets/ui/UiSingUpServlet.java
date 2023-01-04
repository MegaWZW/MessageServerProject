package com.mycompany.app.message_server.controllers.web.servlets.ui;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UiSingUpServlet", urlPatterns = "/ui/singUp")
public class UiSingUpServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{

		request.setCharacterEncoding("UTF-8");

		request.getRequestDispatcher("/jsp/register/singUp.jsp").forward(request, response);
	}
}
