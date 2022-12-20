package com.mycompany.app.message_server.service.api;

import com.mycompany.app.message_server.core.dto.MessageDTO;

public interface IMessageService {
	void save (MessageDTO dto);
}
