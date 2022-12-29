package com.mycompany.app.message_server.controllers;

import com.mycompany.app.message_server.controllers.utils.DateValidation;
import com.mycompany.app.message_server.core.dto.UserDTO;
import com.mycompany.app.message_server.service.api.IUserService;
import com.mycompany.app.message_server.service.factories.UserServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/api/user")
public class RegistrationServlet extends HttpServlet {

	private final IUserService userService;

	private static final String PARAMETER_LOGIN = "login";
	private static final String PARAMETER_PASSWORD = "password";
	private static final String PARAMETER_FIO = "fio";
	private static final String PARAMETER_BIRTH_YEAR = "year";
	private static final String PARAMETER_BIRTH_MONTH = "month";
	private static final String PARAMETER_BIRTH_DAY = "day";


	public RegistrationServlet() {
		this.userService = UserServiceSingleton.getInstance();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String login = request.getParameter(PARAMETER_LOGIN);
		String password = request.getParameter(PARAMETER_PASSWORD);
		String fio = request.getParameter(PARAMETER_FIO);
		Integer year = Integer.parseInt(request.getParameter(PARAMETER_BIRTH_YEAR));
		Integer month = Integer.parseInt(request.getParameter(PARAMETER_BIRTH_MONTH));
		Integer day = Integer.parseInt(request.getParameter(PARAMETER_BIRTH_DAY));

		DateValidation.validate(year, month, day);

		GregorianCalendar birthDate = null;

		switch (month){
			case 1: birthDate = new GregorianCalendar(year, Calendar.JANUARY, day);
			case 2: birthDate = new GregorianCalendar(year, Calendar.FEBRUARY, day);
			case 3: birthDate = new GregorianCalendar(year, Calendar.MARCH, day);
			case 4: birthDate = new GregorianCalendar(year, Calendar.APRIL, day);
			case 5: birthDate = new GregorianCalendar(year, Calendar.MAY, day);
			case 6: birthDate = new GregorianCalendar(year, Calendar.JUNE, day);
			case 7: birthDate = new GregorianCalendar(year, Calendar.JULY, day);
			case 8: birthDate = new GregorianCalendar(year, Calendar.AUGUST, day);
			case 9: birthDate = new GregorianCalendar(year, Calendar.SEPTEMBER, day);
			case 10: birthDate = new GregorianCalendar(year, Calendar.OCTOBER, day);
			case 11: birthDate = new GregorianCalendar(year, Calendar.NOVEMBER, day);
			case 12: birthDate = new GregorianCalendar(year, Calendar.DECEMBER, day);
		}

		userService.save(new UserDTO(login, password, fio, birthDate));

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.write("<h1>" + "Пользователь успешно зарегестрирован" + "</h1>");
	}
}
