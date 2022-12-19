package com.mycompany.app.message_server.dao.api;

import com.mycompany.app.message_server.core.Message;

import java.util.List;

public interface IMessageDao {
    /**
     * метод для получения списка, хранящегося внутри Dao
     * @return список строк
     */
    List<Message> getData();

    /**
     * метод для сохранения объекта Голос в DAO
     * @param message
     */
    void save(Message message);
}
