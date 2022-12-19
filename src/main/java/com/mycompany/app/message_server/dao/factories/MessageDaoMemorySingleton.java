package com.mycompany.app.message_server.dao.factories;

import com.mycompany.app.message_server.core.Message;
import com.mycompany.app.message_server.dao.MessageDao;
import com.mycompany.app.message_server.dao.api.IMessageDao;
import com.mycompany.app.message_server.service.MessageService;
import com.mycompany.app.message_server.service.fabric.MessageServiceSingleton;

import java.util.List;

public class MessageDaoMemorySingleton {
    private volatile static MessageDao instance;

    private MessageDaoMemorySingleton() {
    }

    private static List<Message> messages;
    public static IMessageDao getInstance() {
        if(instance == null){
            synchronized (MessageServiceSingleton.class){
                if(instance == null){
                    instance = new MessageDao(messages);
                }
            }
        }
        return instance;
    }
}
