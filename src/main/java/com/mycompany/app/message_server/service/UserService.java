package com.mycompany.app.message_server.service;

import com.mycompany.app.message_server.core.dto.RegisteredUserDTO;
import com.mycompany.app.message_server.core.dto.UserDTO;
import com.mycompany.app.message_server.dao.api.IUserDao;
import com.mycompany.app.message_server.service.api.IMessageService;
import com.mycompany.app.message_server.service.api.IUserService;

import java.util.List;
import java.util.NoSuchElementException;

public class UserService implements IUserService {
	private final IUserDao dao;
	private final IMessageService messageService;

	public UserService(IUserDao dao, IMessageService messageService) {
		this.dao = dao;
		this.messageService = messageService;
	}

	@Override
	public void save(UserDTO dto) {
		this.validate(dto);
		RegisteredUserDTO registeredUser = new RegisteredUserDTO(dto, false);
		this.dao.save(registeredUser);
	}

	@Override
	public RegisteredUserDTO getUser(String login) {
		RegisteredUserDTO user = this.dao.getUser(login);
		if (user != null){
			return user;
		}else{
			return null;
		}
	}

	@Override
	public List<RegisteredUserDTO> getUsers() {
		return this.dao.getUsers();
	}

	@Override
	public boolean isExist(String login) {
		if(login == null || login.isBlank()){
			throw new IllegalArgumentException("Логин не может быть пустым");
		}
		return this.dao.isExist(login);
	}

	private void validate (UserDTO dto){
		if(dto.getLogin() == null || dto.getLogin().isBlank()){
			throw new IllegalArgumentException("Не передан логин");
		}

		if (dto.getLogin().length() < 5 || dto.getLogin().length() > 15){
			throw new IllegalArgumentException("Логин должен содержать от 5 до 15 символов");
		}

		if(dto.getFio() == null || dto.getFio().isBlank()){
			throw new IllegalArgumentException("Не передано ФИО");
		}

		if(dto.getFio().length() > 50){
			throw new IllegalArgumentException("ФИО не должно содержать больше 50 символов");
		}

		if(dto.getPassword() == null || dto.getPassword().isBlank()){
			throw new IllegalArgumentException("Пароль не должен быть пустым");
		}

		if (dto.getPassword().length() < 5 || dto.getPassword().length() > 15){
			throw new IllegalArgumentException("Пароль должен содержать от 5 до 15 символов");
		}

		if(dto.getBirthDate() == null){
			throw new IllegalArgumentException("Должна быть заполнена дата рождения");
		}

		if(isExist(dto.getLogin())){
			throw new IllegalArgumentException("Пользователь с таким логином существует");
		}
	}
}
