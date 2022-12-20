package com.mycompany.app.message_server.service;

import com.mycompany.app.message_server.core.dto.AcceptedMessageDTO;
import com.mycompany.app.message_server.core.dto.MessageDTO;
import com.mycompany.app.message_server.dao.api.IMessageDao;
import com.mycompany.app.message_server.service.api.IMessageService;

public class MessageService implements IMessageService {
	private final IMessageDao dao;

	public MessageService(IMessageDao dao) {
		this.dao = dao;
	}

	@Override
	public void save(MessageDTO dto) {
		this.validate(dto);
		AcceptedMessageDTO acceptedMessage = new AcceptedMessageDTO(dto);
		this.dao.save(acceptedMessage);
	}

	private void validate(MessageDTO dto){
		if (dto.getText() == null || dto.getText().isBlank()){
			throw new IllegalArgumentException("Поле сообщения не может быть пустым");
		}

		if (dto.getText().length() > 150){
			throw new IllegalArgumentException("Сообщение не должно содержать более 150 символов");
		}
	}

}
