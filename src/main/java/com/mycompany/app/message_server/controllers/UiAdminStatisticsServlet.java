package com.mycompany.app.message_server.controllers;

import com.mycompany.app.message_server.core.dto.StatisticsResultDTO;
import com.mycompany.app.message_server.service.api.IStatisticsService;
import com.mycompany.app.message_server.service.factories.StatisticsServiceSingleton;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
Сервлет не пргодился, возможно надо его удалить
 */
public class UiAdminStatisticsServlet extends HttpServlet {
    private IStatisticsService service;

    public UiAdminStatisticsServlet(){
        this.service = StatisticsServiceSingleton.getInstance();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws IOException, ServletException{
        StatisticsResultDTO result = service.getResult();

        //Map<MessageDTO, Long> allMessages = result.getMessagesAmount();
        //List<MessageDTO> messageDTOS = result.getUsersAmount();
        //List<ResultRow<GenreDTO>> topGenre = result.getMessagesAmount();
        //req.setAttribute("", allMessages);
        //req.setAttribute("", aboutRows);
        //req.setAttribute("", topGenre);

        req.getRequestDispatcher("statistics.jsp").forward(req, resp);

    }
}
