package com.mycompany.app.message_server.dao;

import com.mycompany.app.message_server.core.dto.RegisteredUserDTO;
import com.mycompany.app.message_server.core.dto.UserDTO;
import com.mycompany.app.message_server.dao.api.IUserDao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class UserDao implements IUserDao {

	private List<RegisteredUserDTO> users = new ArrayList<>();

	public UserDao(List<RegisteredUserDTO> users) {
		this.users = users;
	}

	public UserDao(){
		this.users.add(new RegisteredUserDTO(new UserDTO("admin", "admin", "ФИО",
				new GregorianCalendar(1970, Calendar.JANUARY, 1)),true));
	}

	@Override
	public List<RegisteredUserDTO> getUsers() {
		return users;
	}

	@Override
	public boolean isExist(String login) {
		List<RegisteredUserDTO> registeredUsers = getUsers();
		for (RegisteredUserDTO user : registeredUsers){
			if(login.equals(user.getDto().getLogin())){
				return true;
			}
		}
		return false;
	}

	@Override
	public void save(RegisteredUserDTO user) {
		this.users.add(user);
	}
}
