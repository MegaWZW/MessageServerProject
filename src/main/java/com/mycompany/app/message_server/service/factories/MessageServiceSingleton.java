package com.mycompany.app.message_server.service.factories;

import com.mycompany.app.message_server.dao.factories.MessageDaoMemorySingleton;
import com.mycompany.app.message_server.service.MessageService;
import com.mycompany.app.message_server.service.api.IMessageService;

public class MessageServiceSingleton {
	private volatile static MessageService instance;

	private MessageServiceSingleton(){};

	public static IMessageService getInstance(){
		if (instance == null){
			synchronized (MessageServiceSingleton.class){
				if(instance == null){
					instance = new MessageService(MessageDaoMemorySingleton.getInstance());
				}
			}
		}
		return instance;
	}
}
