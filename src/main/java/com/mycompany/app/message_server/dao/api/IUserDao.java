package com.mycompany.app.message_server.dao.api;

import com.mycompany.app.message_server.core.dto.RegisteredUserDTO;

import java.util.List;

public interface IUserDao {
	List<RegisteredUserDTO> getUsers();
	RegisteredUserDTO getUser(String login);
	boolean isExist (String login);
	void save (RegisteredUserDTO user);
}
