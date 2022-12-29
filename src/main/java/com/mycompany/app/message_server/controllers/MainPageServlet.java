package com.mycompany.app.message_server.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MainPageServlet", urlPatterns = "/ui")
public class MainPageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("/main.jsp").forward(request, response);
	}
}
