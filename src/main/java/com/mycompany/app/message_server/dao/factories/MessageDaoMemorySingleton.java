package com.mycompany.app.message_server.dao.factories;

import com.mycompany.app.message_server.dao.MessageDao;
import com.mycompany.app.message_server.dao.api.IMessageDao;

public class MessageDaoMemorySingleton {
	private volatile static MessageDao instance;

	private MessageDaoMemorySingleton(){};

	public static IMessageDao getInstance(){
		if (instance == null){
			synchronized (MessageDaoMemorySingleton.class){
				if (instance == null){
					instance = new MessageDao();
				}
			}
		}
		return instance;
	}
}
