package com.mycompany.app.message_server.dao;

import com.mycompany.app.message_server.core.dto.AcceptedMessageDTO;
import com.mycompany.app.message_server.core.dto.MessageDTO;
import com.mycompany.app.message_server.core.dto.RegisteredUserDTO;
import com.mycompany.app.message_server.core.dto.UserDTO;
import com.mycompany.app.message_server.dao.api.IMessageDao;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class MessageDao implements IMessageDao {

	private List<AcceptedMessageDTO> messages = new ArrayList<>();

	@Override
	public List<AcceptedMessageDTO> getMessages() {
		return messages;
	}

	@Override
	public List<AcceptedMessageDTO> getMessagesForUser(RegisteredUserDTO registeredUser) {
		String login = registeredUser.getDto().getLogin();
		List<AcceptedMessageDTO> messagesForUser = new ArrayList<>();
		for(AcceptedMessageDTO message : messages){

			if(isUserMessage(message,login)){
				messagesForUser.add(message);
			}
		}
		return messagesForUser;
	}

	private boolean isUserMessage(AcceptedMessageDTO message,String login){
		MessageDTO msgDTO = message.getMessage();

		if(msgDTO == null)
			throw new NoSuchElementException("Сообщение отсутствует");
		RegisteredUserDTO registeredUserDTO = msgDTO.getTo();
		if(registeredUserDTO == null)
			throw new NoSuchElementException("Адресат письма отсутствет");
		UserDTO userDTO = registeredUserDTO.getDto();
		if(userDTO == null)
			throw new NoSuchElementException("Адресат не зарегистрирован");
		String tempLogin = userDTO.getLogin();
		if(tempLogin==null)
			throw new NoSuchElementException("У адресата отсутсвует логин");
		return login.equals(tempLogin);

	}
	@Override
	public void save(AcceptedMessageDTO message) {
		this.messages.add(message);
	}
}
