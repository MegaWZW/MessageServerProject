package com.mycompany.app.message_server.service.api;

import com.mycompany.app.message_server.core.dto.AcceptedMessageDTO;
import com.mycompany.app.message_server.core.dto.MessageDTO;
import com.mycompany.app.message_server.core.dto.RegisteredUserDTO;

import java.util.List;

public interface IMessageService {
	void save (MessageDTO dto);
	List<AcceptedMessageDTO> getMessages();
	List<AcceptedMessageDTO> getMessagesForUser(RegisteredUserDTO registeredUser);
}
