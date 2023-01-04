package com.mycompany.app.message_server.controllers.web.servlets;

import com.mycompany.app.message_server.controllers.utils.UserValidation;
import com.mycompany.app.message_server.core.dto.RegisteredUserDTO;
import com.mycompany.app.message_server.service.api.IUserService;
import com.mycompany.app.message_server.service.factories.UserServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AuthorisationServlet", urlPatterns = "/api/login")
public class AuthorisationServlet extends HttpServlet {

	private final IUserService userService;

	private static final String PARAMETER_LOGIN = "login";
	private static final String PARAMETER_PASSWORD = "password";

	public AuthorisationServlet(){
		this.userService = UserServiceSingleton.getInstance();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String login = request.getParameter(PARAMETER_LOGIN);
		String password = request.getParameter(PARAMETER_PASSWORD);

		UserValidation.validate(login, password, userService);

		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession();
		RegisteredUserDTO registeredUser = userService.getUser(login);

		if(!registeredUser.equals(session.getAttribute("user"))){
			session.setAttribute("user", registeredUser);

		}else{
			throw new IllegalArgumentException("Данный пользователь уже авторизован");
		}

		request.getRequestDispatcher("/jsp/main/mainReg.jsp").forward(request,response);
	}
}
