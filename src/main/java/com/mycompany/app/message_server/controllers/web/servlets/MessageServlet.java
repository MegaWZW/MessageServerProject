package com.mycompany.app.message_server.controllers.web.servlets;

import com.mycompany.app.message_server.core.dto.AcceptedMessageDTO;
import com.mycompany.app.message_server.core.dto.MessageDTO;
import com.mycompany.app.message_server.core.dto.RegisteredUserDTO;
import com.mycompany.app.message_server.service.api.IMessageService;
import com.mycompany.app.message_server.service.api.IUserService;
import com.mycompany.app.message_server.service.factories.MessageServiceSingleton;
import com.mycompany.app.message_server.service.factories.UserServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

@WebServlet(name = "MessageServlet", urlPatterns = "/api/message")
public class MessageServlet extends HttpServlet {

	private final IMessageService messageService;
	private final IUserService userService;

	private static final String PARAMETER_RECEIVER_LOGIN = "to";
	private static final String PARAMETER_MESSAGE_TEXT = "text";

	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public MessageServlet(){
		this.messageService = MessageServiceSingleton.getInstance();
		this.userService = UserServiceSingleton.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		RegisteredUserDTO receiver = (RegisteredUserDTO) session.getAttribute("user");
		List<AcceptedMessageDTO> messagesForUser = messageService.getMessagesForUser(receiver);

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.write("<h2>" + "Сообщения для пользователя  " + receiver.getDto().getLogin() + ": " + "</h2>");
		out.write("<br>");
		for(AcceptedMessageDTO message : messagesForUser){
			out.write("<p>" + message.getDtAcceptance().format(formatter) + ": " + message.getMessage().getText()
			+ "</p>");
			out.write("<br>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		RegisteredUserDTO sender = (RegisteredUserDTO) session.getAttribute("user");

		String receiverLogin = request.getParameter(PARAMETER_RECEIVER_LOGIN);
		if(receiverLogin == null){
			throw new NoSuchElementException("Поле получателя не может быть пустым");
		}
		RegisteredUserDTO receiver = userService.getUser(receiverLogin);
		if(receiver == null){
			throw new NoSuchElementException("Пользователя, которому Вы хотите отправить сообщение, не существует");
		}

		String messageText = request.getParameter(PARAMETER_MESSAGE_TEXT);

		MessageDTO message = new MessageDTO(sender, receiver, messageText);
		messageService.save(message);
		response.setContentType("text/html; charset=UTF-8");
		request.getRequestDispatcher("/jsp/message/messageSent.jsp").forward(request,response);
	}
}
