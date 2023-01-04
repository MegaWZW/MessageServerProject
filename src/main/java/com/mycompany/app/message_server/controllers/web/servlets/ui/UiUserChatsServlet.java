package com.mycompany.app.message_server.controllers.web.servlets.ui;

import com.mycompany.app.message_server.core.dto.AcceptedMessageDTO;
import com.mycompany.app.message_server.core.dto.RegisteredUserDTO;
import com.mycompany.app.message_server.service.api.IMessageService;
import com.mycompany.app.message_server.service.factories.MessageServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UiUserChatsServlet", urlPatterns = "/ui/user/chats")
public class UiUserChatsServlet extends HttpServlet {

	private final IMessageService messageService;

	public UiUserChatsServlet(){
		this.messageService = MessageServiceSingleton.getInstance();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		RegisteredUserDTO receiver = (RegisteredUserDTO) session.getAttribute("user");
		List<AcceptedMessageDTO> messagesForUser = messageService.getMessagesForUser(receiver);

		request.setAttribute("receiver", receiver);
		request.setAttribute("messages", messagesForUser);
		request.getRequestDispatcher("/jsp/message/chats.jsp").forward(request, response);
	}
}
