package com.mycompany.app.message_server.dao.api;

import com.mycompany.app.message_server.core.dto.AcceptedMessageDTO;

import java.util.List;

public interface IMessageDao {
	List<AcceptedMessageDTO> getMessages();
	void save(AcceptedMessageDTO message);
}
