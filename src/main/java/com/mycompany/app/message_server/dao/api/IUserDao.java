package com.mycompany.app.message_server.dao.api;

import com.mycompany.app.message_server.core.User;

import java.util.List;


public interface IUserDao {
    /**
     * метод для получения списка, хранящегося внутри Dao
     * @return список строк
     */
    List<User> getData();

    /**
     * Добавляет пользователя в Dao
     * @param user пользователь, которого нужно добавить
     */
    public void addUser(User user);

    /**
     * Удаляет пользователя из Dao
     * @param user пользователь, которого необходимо удалить
     */
    public void deleteUser(User user);

}
