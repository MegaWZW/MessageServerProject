package com.mycompany.app.message_server.dao.factories;

import com.mycompany.app.message_server.dao.UserDao;
import com.mycompany.app.message_server.dao.api.IUserDao;

public class UserDaoMemorySingleton {
	private volatile static UserDao instance;

	private UserDaoMemorySingleton(){};

	public static IUserDao getInstance(){
		if (instance == null){
			synchronized (UserDaoMemorySingleton.class){
				if (instance == null){
					instance = new UserDao();
				}
			}
		}
		return instance;
	}
}
