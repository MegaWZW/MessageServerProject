package com.mycompany.app.message_server.controllers.utils;

import com.mycompany.app.message_server.service.api.IUserService;

public class UserValidation {

	public static void validate(String login, String password, IUserService userService){
		if(!userService.isExist(login)){
			throw new IllegalArgumentException("Пользователя с таким логином не существует");
		}

		if(!userService.getUser(login).getDto().getPassword().equals(password)){
			throw new IllegalArgumentException("Введён неверный пароль");
		}
	}
}
