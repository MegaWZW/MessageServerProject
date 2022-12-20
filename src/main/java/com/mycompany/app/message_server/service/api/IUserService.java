package com.mycompany.app.message_server.service.api;

import com.mycompany.app.message_server.core.dto.UserDTO;

public interface IUserService {
	void save(UserDTO dto);
	boolean isExist(String login);
}
