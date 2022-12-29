package com.mycompany.app.message_server.service.api;

import com.mycompany.app.message_server.core.dto.RegisteredUserDTO;
import com.mycompany.app.message_server.core.dto.UserDTO;

import java.util.List;

public interface IUserService {
	void save(UserDTO dto);
	RegisteredUserDTO getUser(String login);
	List<RegisteredUserDTO> getUsers();
	boolean isExist(String login);
}
