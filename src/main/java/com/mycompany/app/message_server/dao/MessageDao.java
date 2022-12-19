package com.mycompany.app.message_server.dao;

import com.mycompany.app.message_server.core.Message;
import com.mycompany.app.message_server.dao.api.IMessageDao;

import java.util.List;

public class MessageDao implements IMessageDao {
    private List<Message> messages;

    public MessageDao(List<Message> messages) {
        this.messages = messages;
    }

    /**
     * Метод для получения списка всех сообщений
     * @return список, содержащий объекты Сообщение
     */

    @Override
    public List<Message> getData() {
        return messages;
    }

    /**
     * Метод для сохранения сообщения в список
     * @param message объект типа Сообщение, содержащий информацию о дате/времени отправки сообщения,
     *             имя отправителя, имя получателя, текст сообщения оставленного отправителем
     */
    @Override
    public void save(Message message) {
        messages.add(message);
    }
}
