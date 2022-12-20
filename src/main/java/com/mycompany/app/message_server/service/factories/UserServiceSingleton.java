package com.mycompany.app.message_server.service.factories;

import com.mycompany.app.message_server.dao.factories.UserDaoMemorySingleton;
import com.mycompany.app.message_server.service.UserService;
import com.mycompany.app.message_server.service.api.IUserService;

public class UserServiceSingleton {
	private volatile static UserService instance;

	private UserServiceSingleton(){};

	public static IUserService getInstance() {
		if(instance == null){
			synchronized (UserServiceSingleton.class){
				if(instance == null){
					instance = new UserService(UserDaoMemorySingleton.getInstance(),
							MessageServiceSingleton.getInstance());
				}
			}
		}
		return instance;
	}
}
