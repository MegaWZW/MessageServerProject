package com.mycompany.app.message_server.dao.factories;

import com.mycompany.app.message_server.core.Message;
import com.mycompany.app.message_server.core.User;
import com.mycompany.app.message_server.dao.UserDao;
import com.mycompany.app.message_server.dao.api.IUserDao;
import com.mycompany.app.message_server.service.fabric.MessageServiceSingleton;

import java.util.List;

public class UserDaoMemorySingleton {
    private volatile static UserDao instance;

    private UserDaoMemorySingleton() {
    }
    private static List<User> users;

    public static IUserDao getInstance() {
        if(instance == null) {
            synchronized (UserDaoMemorySingleton.class) {
                if (instance == null) {
                    instance = new UserDao(users);
                }
            }
        }
        return instance;
    }
}
