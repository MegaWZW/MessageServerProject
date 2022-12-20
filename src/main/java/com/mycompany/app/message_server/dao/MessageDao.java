package com.mycompany.app.message_server.dao;

import com.mycompany.app.message_server.core.dto.AcceptedMessageDTO;
import com.mycompany.app.message_server.dao.api.IMessageDao;

import java.util.ArrayList;
import java.util.List;

public class MessageDao implements IMessageDao {

	private List<AcceptedMessageDTO> messages = new ArrayList<>();

	@Override
	public List<AcceptedMessageDTO> getMessages() {
		return messages;
	}

	@Override
	public void save(AcceptedMessageDTO message) {
		this.messages.add(message);
	}
}
