package com.mycompany.app.message_server.dao;

import com.mycompany.app.message_server.core.User;
import com.mycompany.app.message_server.dao.api.IUserDao;

import java.util.List;

public class UserDao implements IUserDao {
    private List<User> users;

    public UserDao(List<User> users) {
        this.users = users;
    }

    /**
     * Метод для получения списка пользователей, хранящихся в Dao
     * @return список имён артистов
     */
    @Override
    public List<User> getData() {
        return users;
    }

    /**
     * Добавляет фио пользователя в список всех пользователей
     * @param user пользователь, которого нужно добавить
     */
    @Override
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Метод для удаления пользователя из списка всех зарегестрированных пользователей
     * @param user пользователь, которого необходимо удалить
     */
    @Override
    public void deleteUser(User user) {
        users.remove(user);
    }
}
